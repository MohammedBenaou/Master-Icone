<?php 
$dirname = './TP_PHP/'; 
$dir = opendir($dirname); 

while($file = readdir($dir)) { 
if($file != '.' && $file != '..' && !is_dir($dirname.$file)) 
{ 
echo '- <a href="'.$dirname.$file.'">'.$file.'</a>'.'<br /><br />'; 
} 
} 
//closedir($dir); 
?> 