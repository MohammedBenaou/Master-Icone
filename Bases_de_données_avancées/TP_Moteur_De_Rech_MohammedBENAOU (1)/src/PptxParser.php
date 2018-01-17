<?php

namespace MySearchEngine;

include ("..\phpoffice\phppresentation\src\PhpPresentation\IOFactory.php");

class PptxParser extends Parser{
	private $parser;

	protected static $type = 'pptx';

	protected function getPptxParser(){
		if (!isset($this->parser)){
			$this->parser = new \PhpOffice\PhpPresentation\PhpPresentation();
		}
		return $this->parser;
	}

	public function parse($path){
		$Pptx = \PhpOffice\PhpPresentation\IOFactory::load($path);
		$info = $Pptx->getProperties();
		$meta = array(
			'TITLE'=>$info->getTitle(),
			'keyWords'=>$info->getKeyWords(),
			'Descriptiuon'=>$info->getDescription(),
			'creator'=>$info->getCreator()
		);
		return $meta;
	}
}