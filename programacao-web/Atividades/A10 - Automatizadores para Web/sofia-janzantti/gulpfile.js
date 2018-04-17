var gulp = require('gulp'),
cssmin = require('gulp-cssmin'),
watch = require('gulp-watch');

//realiza minificação do css
gulp.task('build-css', function(){
	gulp.assets('assets/css/*.css').
	pipe(cssmin()).
	pipe(gulp.dest('assets/cssmin'));
});


//olhar se os arquivos foram modificados, e realizar a alteração em jsmin e cssmin
gulp.task('watch', function() {
  gulp.watch('assets/css/*.css', ['build-css']);
});