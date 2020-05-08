var exec = require('cordova/exec');

function AutoStartPermission() {
  this.sdkVersion = 0;
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
  var _self = this;
  cordova.exec(function (res) { console.log('Autostart Permission Version Response', res); _self.sdkVersion = res; }, function (err) { console.error('Autostart Permission Version Error', err) }, "AutoStartPermission", "getBuildVersion", []);
}; 

if (!window.plugins) {
  window.plugins = {};
}
var autoStartPermission = new AutoStartPermission();  
autoStartPermission.getBuildVersion();
if (!window.plugins.AutoStartPermission) {
  window.plugins.AutoStartPermission = autoStartPermission;
}
module.exports = autoStartPermission;

