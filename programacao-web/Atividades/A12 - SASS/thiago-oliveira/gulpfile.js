var gulp = require('gulp');
var sass = require('gulp-sass');
var rename = require('gulp-rename')

//SASS SOURCE
var scssFiles = "./src/assets/scss/style.scss";

//CSS DESTINATION
var cssDest = "./src/assets/css/";
var cssMinDest = "./src/assets/scss/";


var sassDevOptions = {
	outputStyle: 'expanded'
}
var sassProdOptions = {
	outputStyle: 'compressed'
}
gulp.task('default',['sassdev', 'sassprod', 'watch']);
	// console.log('Gulp functionando...');

//task to run sass
gulp.task('sassdev', function(){
	return gulp.src(scssFiles)
		.pipe(sass(sassDevOptions).on('error', sass.logError))
		.pipe(gulp.dest(cssDest));
});

gulp.task('sassprod', function(){
	return gulp.src(scssFiles)
		.pipe(sass(sassProdOptions).on('error', sass.logError))
		.pipe(rename("style.min.css"))
		.pipe(gulp.dest(cssDest));
});
//task que ir'a rodar nossas funcoes (sassdev/sassprod) toda que vez que os arquivos localizados em 	(scssFiles) forem alterados
gulp.task('watch', function(){
	gulp.watch(scssFiles, ['sassdev', 'sassprod']);
	console.log('teste');
});
