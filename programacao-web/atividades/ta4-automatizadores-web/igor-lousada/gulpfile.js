var gulp = require('gulp'), 
cssmin = require('gulp-cssmin'),
jsmin = require('gulp-uglify'),
watch = require('gulp-watch');

gulp.task('min_css', function(){

gulp.src('./*.css').pipe(cssmin()).pipe(gulp.dest('./dist'));
});

gulp.task('min_js', function(){

gulp.src('./*.js').pipe(jsmin()).pipe(gulp.dest('./dist'));
});

gulp.task('watch', function() {
  gulp.watch('./*.css', ['min_css']);
  gulp.watch('./js/*.js', ['min_js']);
});
