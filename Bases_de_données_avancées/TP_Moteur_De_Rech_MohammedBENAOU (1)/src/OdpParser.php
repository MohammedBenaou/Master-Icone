<?php

namespace MySearchEngine;

include ("..\phpoffice\phppresentation\src\PhpPresentation\IOFactory.php");

class OdpParser extends Parser{
	private $parser;

	protected static $type = 'odp';

	protected function getOdpParser(){
		if (!isset($this->parser)){
			$this->parser = new \PhpOffice\PhpPresentation\PhpPresentation();
		}
		return $this->parser;
	}

	public function parse($path){
		$Odp = \PhpOffice\PhpPresentation\IOFactory::load($path);
		$info = $Odp->getProperties();
		$meta = array(
			'TITLE'=>$info->getTitle(),
			'keyWords'=>$info->getKeyWords(),
			'Descriptiuon'=>$info->getDescription(),
			'creator'=>$info->getCreator()
		);		
		return $meta;
	}
}