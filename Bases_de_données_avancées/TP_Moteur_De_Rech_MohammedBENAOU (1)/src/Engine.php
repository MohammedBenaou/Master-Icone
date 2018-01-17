<?php

/**
 * Engine.php
 *
 * @copyright  2015 Christophe Demko christophe.demko@univ-lr.fr
 * @license    CeCILL-B http://www.cecill.info/licences/Licence_CeCILL-B_V1-en.html
 */

namespace MySearchEngine;

/**
 * Engine class
 *
 * @since  0.0.1
 */
class Engine
{
	/**
	 * Engine client
	 */
	private $client;

	/**
	 * Engine index
	 */
	private $index;

	/**
	 * Engine type
	 */
	private $type;

	/**
	 * Constructor
	 */
	public function __construct()
	{
		$this->index = 'my_index';
		$this->type = 'document';
	}

	/**
	 * Get the clien (lazy instantiation)
	 *
	 * @return  \Elasticsearch\Client
	 */
	protected function getClient()
	{
		if (!isset($this->client))
		{
			$this->client = \Elasticsearch\ClientBuilder::create()->build();
		}

		return $this->client;
	}

	/**
	 * Index a path
	 *
	 * @param   string  $path  The pathname
	 *
	 * @return  void
	 */
	public function index($path)
	{
		$doc = DocumentBuilder::create()->build($path);
		$meta = $doc->parse();
		$params = ['index' => $this->index, 'type' => $this->type, 'id' => md5($path), 'body' => $meta];
		$this->getClient()->index($params);
	}

	/**
	 * Search a query string
	 *
	 * @param   string  $query  The query string
	 *
	 * @return  void
	 */
	public function search($query)
	{
		$params = ['index' => $this->index, 'type' => $this->type, 'q' => $query];
		$search = $this->getClient()->search($params);

		$result = [];

		foreach ($search['hits']['hits'] as $hit)
		{
			$result[] = ['score' => $hit['_score'], 'path' => $hit['_source']['path']];
		}

		return $result;
	}

	/**
	 * Delete a path
	 *
	 * @param   string  $path  The pathname
	 *
	 * @return  void
	 */
	public function delete($path)
	{
		$doc = DocumentBuilder::create()->build($path);
		$id = md5($path);
		$params = ['index' => $this->index, 'type' => $this->type, 'id' => $id];
		$this->getClient()->delete($params);
	}
}
