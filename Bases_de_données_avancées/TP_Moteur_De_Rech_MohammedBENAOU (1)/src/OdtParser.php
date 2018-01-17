<?php

namespace MySearchEngine;

class OdtParser extends Parser{
	private $parser;

	protected static $type = 'odt';

	protected function getOdtParser(){
		if (!isset($this->parser)){
			$this->parser = new \PhpOffice\PhpWord\PhpWord();
		}
		return $this->parser;
	}

	public function parse($path){
		$odt = \PhpOffice\PhpWord\IOFactory::load($path, 'ODText');
		$info = $odt->getDocInfo();
		$meta = array(
			'TITLE'=>$info->getTitle(),
			'keyWords'=>$info->getKeyWords(),
			'Descriptiuon'=>$info->getDescription(),
			'creator'=>$info->getCreator()
		);
		return $meta;
	}
}