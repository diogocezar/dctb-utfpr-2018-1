var gulp = require('gulp'),
cssmin = require('gulp-cssmin'),
jsmin = require('gulp-uglify'),
watch = require('gulp-watch');

//realiza minificação do css
gulp.task('build-css', function(){
	gulp.assets('assets/css/*.css').
	pipe(cssmin()).
	pipe(gulp.dest('assets/cssmin'));
});

//realiza minificação do javascript
gulp.task('build-js', function(){
	gulp.assets('assets/js/*.js').
	pipe(jsmin()).
	pipe(gulp.dest('assets/jsmin'));
});

//olhar se os arquivos foram modificados, e realizar a alteração em jsmin e cssmin
gulp.task('watch', function() {
  gulp.watch('assets/css/*.css', ['build-css']);
  gulp.watch('assets/js/*.js', ['build-js']);
});