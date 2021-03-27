const path = require('path');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

const PATHS = {
  src: path.join(__dirname, 'src'),
  build: path.join(__dirname, 'build'),
};

module.exports = {
  resolve: {
    extensions: ['.js', '.jsx', '.ts', '.tsx'],
  },

  entry: [path.join(PATHS.src, 'index.tsx')],

  output: {
    path: PATHS.build,
  },

  devtool: 'source-map',

  module: {
    rules: [
      {
        test: /\.tsx?$/,
        enforce: 'pre',
        use: 'tslint-loader',
        include: PATHS.src,
      },
      {
        test: /\.(js|ts)x?$/,
        use: 'babel-loader',
        include: PATHS.src,
      },
      {
        test: /\.css$/,
        use: [MiniCssExtractPlugin.loader, 'css-loader', 'postcss-loader'],
      },
      {
        test: /\.(png|svg|jpg)$/,
        // inline base64 URLs for <=8k images, direct URLs for the rest
        use: 'url-loader?limit=8192',
      },
    ],
  },
};