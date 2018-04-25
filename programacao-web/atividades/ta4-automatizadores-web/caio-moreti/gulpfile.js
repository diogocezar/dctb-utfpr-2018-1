var gulp = require('gulp'),
cssmin = require('gulp-cssmin'),
jsmin = require('gulp-uglify'),
watch = require('gulp-watch');

//realiza minificação do css
gulp.task('build-css', function(){
	gulp.src('src/css/*.css').
	pipe(cssmin()).
	pipe(gulp.dest('src/cssmin'));
});

//realiza minificação do javascript
gulp.task('build-js', function(){
	gulp.src('src/js/*.js').
	pipe(jsmin()).
	pipe(gulp.dest('src/jsmin'));
});

//olhar se os arquivos foram modificados, e realizar a alteração em jsmin e cssmin
gulp.task('watch', function() {
  gulp.watch('src/css/*.css', ['build-css']);
  gulp.watch('src/js/*.js', ['build-js']);
});
