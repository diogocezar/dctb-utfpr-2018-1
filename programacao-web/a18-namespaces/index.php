<?php

include('class/User.php');

use People\User as U;
use function People\sum as funcSum;
use const People\YEAR as YEAR_CONST;

echo YEAR_CONST;

echo "<br/>";

echo funcSum(1,2);

echo "<br/>";

$u = new U('Diogo', '30');
print($u);

?>