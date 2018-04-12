<?php
	final class ClasseFinal{
		// essa classe não poderá ser herdada
		final function getFinal(){
    		// esse método não poderá ser sobrescrito
			return "Metodo Final";
		}
	}
	$FC = new ClasseFinal();
	echo $FC->getFinal();
?>