var exec = require('cordova/exec');

function AutoStartPermission() {
}

AutoStartPermission.prototype.isAutoStartPermissionAvailable = function () {
  cordova.exec(function (res) { }, function (err) { }, "AutoStartPermission", "isAutoStartPermissionAvailable", []);
  return true;
};
AutoStartPermission.prototype.getAutoStartPermission = function () {
  cordova.exec(function (res) { console.log('Autostart Permission Response', res) }, function (err) { console.error('Autostart Permission Error', err) }, "AutoStartPermission", "getAutoStartPermission", []);
  return true;
};
AutoStartPermission.prototype.getBuildVersion = function () {
  let buildVersion = 0;
  cordova.exec(function (res) { console.log('Autostart Permission Version Response', res); buildVersion = res; }, function (err) { console.error('Autostart Permission Version Error', err) }, "AutoStartPermission", "getBuildVersion", []);
  return buildVersion;
}; 

if (!window.plugins) {
  window.plugins = {};
}
var autoStartPermission = new AutoStartPermission();  
if (!window.plugins.AutoStartPermission) {
  window.plugins.AutoStartPermission = autoStartPermission;
}
module.exports = autoStartPermission;

