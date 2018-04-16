var gulp = require('gulp'),
cssmin = require('gulp-cssmin'),
jsmin = require('gulp-uglify'),
watch = require('gulp-watch');

//realiza minificação do css
gulp.task('build-css', function(){
	gulp.src('dist/css/*.css').
	pipe(cssmin()).
	pipe(gulp.dest('dist/cssmin'));
});

//realiza minificação do javascript
gulp.task('build-js', function(){
	gulp.src('dist/js/*.js').
	pipe(jsmin()).
	pipe(gulp.dest('dist/jsmin'));
});

//olhar se os arquivos foram modificados, e realizar a alteração em jsmin e cssmin
gulp.task('watch', function() {
  gulp.watch('dist/css/*.css', ['build-css']);
  gulp.watch('dist/js/*.js', ['build-js']);
});
