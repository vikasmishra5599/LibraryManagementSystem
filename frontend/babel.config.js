module.exports = (api) => {
  api.cache(true);

  const presets = ['@babel/preset-env', '@babel/preset-typescript', '@babel/react'];
  const plugins = ['@babel/transform-react-jsx', '@babel/plugin-transform-runtime'];

  return {
    presets,
    plugins,
  };
};
