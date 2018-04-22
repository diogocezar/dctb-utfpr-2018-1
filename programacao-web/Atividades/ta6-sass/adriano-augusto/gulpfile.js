var gulp = require('gulp');
var sass = require('gulp-sass');
var rename = require('gulp-rename');

/*
 * Variáveis
 */
// Sass SRC
var scssFiles = './src/scss/style.scss';

// CSS destino
var cssDest = './src/css';

// Opções para desenvolvimento
var sassDevOptions = {
  outputStyle: 'expanded'
}

// Opções para produção
var sassProdOptions = {
  outputStyle: 'compressed'
}

/*
 * Tasks
 */
//Task 'sassdev' - 'gulp sassdev'
gulp.task('sassdev', function() {
  return gulp.src(scssFiles)
    .pipe(sass(sassDevOptions).on('error', sass.logError))
    .pipe(gulp.dest(cssDest));
});

// Task 'sassprod' - 'gulp sassprod'
gulp.task('sassprod', function() {
  return gulp.src(scssFiles)
    .pipe(sass(sassProdOptions).on('error', sass.logError))
    .pipe(rename('style.min.css'))
    .pipe(gulp.dest(cssMinDest));
});

// Task 'watch' - 'gulp watch'
gulp.task('watch', function() {
  gulp.watch(scssFiles, ['sassdev', 'sassprod']);
});

// Default task
gulp.task('default', ['sassdev', 'sassprod', 'watch']);


