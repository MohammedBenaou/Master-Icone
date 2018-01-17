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
class PdfParser extends Parser
{
	private $parser;

	protected static $type = 'pdf';

	/**
	 * Get the pdf parser (lazy instantiation)
	 *
	 * @return  \Smalot\PdfParser\Parser
	 */
	protected function getPdfParser()
	{
		if (!isset($this->parser))
		{
			$this->parser = new \Smalot\PdfParser\Parser;
		}

		return $this->parser;
	}

	/**
	 * Parse document
	 *
	 * @param   string  $path  The pathname
	 *
	 * @return  array  Document meta data
	 */
	public function parse($path)
	{
		$pdf = $this->getPdfParser()->parseFile($path);
		$details = $pdf->getDetails();
		$meta = [];

		if (isset($details['CreationDate']))
		{
			$meta['created'] = $details['CreationDate'];
		}

		if (isset($details['Title']))
		{
			$meta['title'] = $details['Title'];
		}

		if (isset($details['Author']))
		{
			$meta['author'] = $details['Author'];
		}

		if (isset($details['Subject']))
		{
			$meta['description'] = $details['Subject'];
		}

		if (isset($details['Keywords']))
		{
			$meta['keywords'] = $details['Keywords'];
		}

		return $meta;
	}
}
