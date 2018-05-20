var gulp = require('gulp');
var uglify = require('gulp-uglify');
var uglifycss = require('gulp-uglifycss');

gulp.task('default', ['uglify', 'css']);

gulp.task('uglify',function(){
  return gulp.src(['.js/*.js'])
    .pipe(uglify())
		.pipe(gulp.dest('./dist/js'));
});

gulp.task('css',function(){
  return gulp.src(['./assets/css/src/*.css'])
    .pipe(uglifycss())
		.pipe(gulp.dest('./dist/css'));
});

gulp.task('watch', function(){
  gulp.watch('./js/*', ['js']);
  gulp.watch('./assets/css/src/*', ['css']);
});
