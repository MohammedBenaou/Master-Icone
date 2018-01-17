<?php

namespace MySearchEngine;

class DocxParser extends Parser{
	private $parser;

	protected static $type = 'docx';

	protected function getDocxParser(){
		if (!isset($this->parser)){
			$this->parser = new \PhpOffice\PhpWord\PhpWord();
		}
		return $this->parser;
	}

	public function parse($path){
		$Docx = \PhpOffice\PhpWord\IOFactory::load($path,'Word2007');
		$info = $Docx->getDocInfo();	
		$meta = array(
			'TITLE'=>$info->getTitle(),
			'keyWords'=>$info->getKeyWords(),
			'Descriptiuon'=>$info->getDescription(),
			'creator'=>$info->getCreator()
		);		
		return $meta;
	}
}