var exec = require('cordova/exec');

function AutoStartPermission() {
}

AutoStartPermission.prototype.isAutoStartPermissionAvailable = function () {
  cordova.exec(function (res) { }, function (err) { }, "AutoStartPermission", "isAutoStartPermissionAvailable", []);
  return true;
};
AutoStartPermission.prototype.getAutoStartPermission = function () {
  console.log('calling1');
  console.log('exec fun', cordova.exec(function (res) { console.log('plugin res', res) }, function (err) { console.err('plugin err', err) }, "AutoStartPermission", "getAutoStartPermission", []));
  console.log('calling2');
  return true;
};


//AutoStartPermission.install = function () {
    if (!window.plugins) {
      window.plugins = {};
    }
    var autoStartPermission = new AutoStartPermission();  
    if (!window.plugins.AutoStartPermission) {
      window.plugins.AutoStartPermission = autoStartPermission;
    }
    console.log('pluigins1', window.plugins.AutoStartPermission);
    console.log('pluigins2', window.plugins.AutoStartPermission.getAutoStartPermission);
    //return window.plugins.AutoStartPermission;
  //};
  
  //cordova.addConstructor(AutoStartPermission.install);
module.exports = autoStartPermission;

