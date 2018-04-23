var gulp = require('gulp'),
    sassmin = require('gulp-sass');

gulp.task('build-sass', function(){
    gulp.src('*.scss')
    .pipe(sassmin())
    .pipe(gulp.dest('./src'));
});

gulp.task('default', ['build-sass']);
