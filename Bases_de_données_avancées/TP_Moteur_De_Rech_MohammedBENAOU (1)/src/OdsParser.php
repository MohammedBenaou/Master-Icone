<?php

namespace MySearchEngine;

include ("..\phpoffice\phpexcel\Classes\PHPExcel\IOFactory.php");

class OdsParser extends Parser{
	private $parser;

	protected static $type = 'ods';

	protected function getOdsParser(){
		if (!isset($this->parser)){
			$this->parser = new \PhpOffice\PhpExcel\PhpExcel();
		}
		return $this->parser;
	}
	
	public function parse($path){
		$Ods = \PHPExcel_IOFactory::load($path);
		$info = $Ods->getProperties();
		$meta = array(
			'TITLE'=>$info->getTitle(),
			'keyWords'=>$info->getKeyWords(),
			'Descriptiuon'=>$info->getDescription(),
			'creator'=>$info->getCreator()
		);
		return $meta;
	}
}