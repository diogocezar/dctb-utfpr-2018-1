var gulp = require('gulp'),
	cssmin = require('gulp-cssmin'),
	jsmin = require('gulp-uglify'),
	watch = require ('gulp-watch');

gulp.task('css',function() {
	console.log('Minificando Arquivos CSS');
	gulp.src('./css/*.css')
	.pipe(cssmin())
	.pipe(gulp.dest('./css/dist'));
});

gulp.task('js',function() {
	console.log('[JS] Minificando Arquivos JavaScript');
	gulp.src('./js/*.js')
	.pipe(jsmin())
	.pipe(gulp.dest('./js/dist'));
});



gulp.task('watch',function() {
	gulp.watch('./css/*.css',['css']);
	gulp.watch('./js/*.js',['js']);
});

gulp.task('default', ['css', 'js', 'watch']);
