<?php

namespace MySearchEngine;

include('imageMetadataParser.php');

class jpgParser extends Parser{
	private $parser;
	protected static $type = 'jpg';
	

	public function parse($path){
var_dump($path);
		$this->parser= new ImageMetadataParser($path);
		 $imageparser = new ImageMetadataParser($path);
		if (!$imageparser->parseExif())
		    echo "Parsing of EXIF failed<br />\n";
		if (!$imageparser->parseIPTC())
		    echo "Parsing of IPTC failed<br />\n";
		/*$meta = array(
		//		'Tilte'=> $imageparser->getTitle(),
				'Time'=>$imageparser->getDateTime(),
				'Orientation'=>$imageparser->getOrientation()
				);*/
		return $meta;
	}
}
