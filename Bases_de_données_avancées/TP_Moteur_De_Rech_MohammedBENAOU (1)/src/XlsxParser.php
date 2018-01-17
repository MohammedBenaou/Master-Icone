<?php

namespace MySearchEngine;

include ("..\phpoffice\phpexcel\Classes\PHPExcel\IOFactory.php");

class XlsxParser extends Parser{
	private $parser;

	protected static $type = 'xlsx';

	protected function getXlsxParser(){
		if (!isset($this->parser)){
			$this->parser = new \PhpOffice\PhpExcel\PhpExcel();
		}
		return $this->parser;
	}

	public function parse($path){
		$Xlsx = \PHPExcel_IOFactory::load($path);
		$info = $Xlsx->getProperties();
		$meta = array(
			'TITLE'=>$info->getTitle(),
			'keyWords'=>$info->getKeyWords(),
			'Descriptiuon'=>$info->getDescription(),
			'creator'=>$info->getCreator()
		);
		return $meta;
	}
}