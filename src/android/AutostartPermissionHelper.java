package cordova.plugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.util.*;

class AutoStartPermissionHelper {

    private static AutoStartPermissionHelper INSTANCE;

    public static AutoStartPermissionHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AutoStartPermissionHelper();
        }
        return INSTANCE;
    }

    private AutoStartPermissionHelper() {

    }

    /***
     * Xiaomi
     */
    private static final String BRAND_XIAOMI = "xiaomi";
    private static final String BRAND_XIAOMI_REDMI = "redmi";
    private static final String PACKAGE_XIAOMI_MAIN = "com.miui.securitycenter";
    private static final String PACKAGE_XIAOMI_COMPONENT = "com.miui.permcenter.autostart.AutoStartManagementActivity";

    /***
     * Letv
     */
    private static final String BRAND_LETV = "letv";
    private static final String PACKAGE_LETV_MAIN = "com.letv.android.letvsafe";
    private static final String PACKAGE_LETV_COMPONENT = "com.letv.android.letvsafe.AutobootManageActivity";

    /***
     * ASUS ROG
     */
    private static final String BRAND_ASUS = "asus";
    private static final String PACKAGE_ASUS_MAIN = "com.asus.mobilemanager";
    private static final String PACKAGE_ASUS_COMPONENT = "com.asus.mobilemanager.powersaver.PowerSaverSettings";
    private static final String PACKAGE_ASUS_COMPONENT_FALLBACK = "com.asus.mobilemanager.autostart.AutoStartActivity";

    /***
     * Honor
     */
    private static final String BRAND_HONOR = "honor";
    private static final String PACKAGE_HONOR_MAIN = "com.huawei.systemmanager";
    private static final String PACKAGE_HONOR_COMPONENT = "com.huawei.systemmanager.optimize.process.ProtectActivity";

    /***
     * Huawei
     */
    private static final String BRAND_HUAWEI = "huawei";
    private static final String PACKAGE_HUAWEI_MAIN = "com.huawei.systemmanager";
    private static final String PACKAGE_HUAWEI_COMPONENT = "com.huawei.systemmanager.optimize.process.ProtectActivity";
    private static final String PACKAGE_HUAWEI_COMPONENT_FALLBACK = "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity";

    /**
     * Oppo
     */
    private static final String BRAND_OPPO = "oppo";
    private static final String PACKAGE_OPPO_MAIN = "com.coloros.safecenter";
    private static final String PACKAGE_OPPO_FALLBACK = "com.oppo.safe";
    private static final String PACKAGE_OPPO_COMPONENT = "com.coloros.safecenter.permission.startup.StartupAppListActivity";
    private static final String PACKAGE_OPPO_COMPONENT_FALLBACK = "com.oppo.safe.permission.startup.StartupAppListActivity";
    private static final String PACKAGE_OPPO_COMPONENT_FALLBACK_A = "com.coloros.safecenter.startupapp.StartupAppListActivity";

    /**
     * Vivo
     */

    private static final String BRAND_VIVO = "vivo";
    private static final String PACKAGE_VIVO_MAIN = "com.iqoo.secure";
    private static final String PACKAGE_VIVO_FALLBACK = "com.vivo.permissionmanager";
    private static final String PACKAGE_VIVO_COMPONENT = "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK = "com.vivo.permissionmanager.activity.BgStartUpManagerActivity";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK_A = "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager";

    /**
     * Nokia
     */

    private static final String BRAND_NOKIA = "nokia";
    private static final String PACKAGE_NOKIA_MAIN = "com.evenwell.powersaving.g3";
    private static final String PACKAGE_NOKIA_COMPONENT = "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity";

    /***
     * Samsung
     */
    private static final String BRAND_SAMSUNG = "samsung";
    private static final String PACKAGE_SAMSUNG_MAIN = "com.samsung.android.lool";
    private static final String PACKAGE_SAMSUNG_COMPONENT = "com.samsung.android.sm.ui.battery.BatteryActivity";

    /***
     * One plus
     */
    private static final String BRAND_ONE_PLUS = "oneplus";
    private static final String PACKAGE_ONE_PLUS_MAIN = "com.oneplus.security";
    private static final String PACKAGE_ONE_PLUS_COMPONENT = "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity";

    private static final List<String> PACKAGES_TO_CHECK_FOR_PERMISSION = Arrays.asList(new String[]{
        PACKAGE_ASUS_MAIN, 
        PACKAGE_XIAOMI_MAIN, 
        PACKAGE_LETV_MAIN, 
        PACKAGE_HONOR_MAIN, 
        PACKAGE_OPPO_MAIN,
        PACKAGE_OPPO_FALLBACK, 
        PACKAGE_VIVO_MAIN, 
        PACKAGE_VIVO_FALLBACK, 
        PACKAGE_NOKIA_MAIN, 
        PACKAGE_HUAWEI_MAIN, 
        PACKAGE_SAMSUNG_MAIN, 
        PACKAGE_ONE_PLUS_MAIN
    });

    public boolean getAutoStartPermission(Context context) {

        switch (Build.BRAND.toLowerCase(Locale.getDefault())) {

            case BRAND_ASUS:  
                return autoStartAsus(context);

            case BRAND_XIAOMI: 
            case BRAND_XIAOMI_REDMI:
                return autoStartXiaomi(context);

            case BRAND_LETV:
                return autoStartLetv(context);

            case BRAND_HONOR:
                return autoStartHonor(context);

            case BRAND_HUAWEI:
                return autoStartHuawei(context);

            case BRAND_OPPO: 
                return autoStartOppo(context);

            case BRAND_VIVO: 
                return autoStartVivo(context);

            case BRAND_NOKIA: 
                return autoStartNokia(context);

            case BRAND_SAMSUNG:
                return autoStartSamsung(context);

            case BRAND_ONE_PLUS:
                return autoStartOnePlus(context);

            default:
                return false;
        }

    }

    public boolean isAutoStartPermissionAvailable(Context context) {

        List<ApplicationInfo> packages;
        packages = context.getPackageManager().getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if (PACKAGES_TO_CHECK_FOR_PERMISSION.contains(packageInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private boolean autoStartXiaomi(Context context) {
        if (isPackageExists(context, PACKAGE_XIAOMI_MAIN)) {
            try {
                startIntent(context, PACKAGE_XIAOMI_MAIN, PACKAGE_XIAOMI_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartAsus(Context context) {
        if (isPackageExists(context, PACKAGE_ASUS_MAIN)) {
            try {
                startIntent(context, PACKAGE_ASUS_MAIN, PACKAGE_ASUS_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    startIntent(context, PACKAGE_ASUS_MAIN, PACKAGE_ASUS_COMPONENT_FALLBACK);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartLetv(Context context) {
        if (isPackageExists(context, PACKAGE_LETV_MAIN)) {
            try {
                startIntent(context, PACKAGE_LETV_MAIN, PACKAGE_LETV_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartHonor(Context context) {
        if (isPackageExists(context, PACKAGE_HONOR_MAIN)) {
            try {
                startIntent(context, PACKAGE_HONOR_MAIN, PACKAGE_HONOR_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartHuawei(Context context) {
        if (isPackageExists(context, PACKAGE_HUAWEI_MAIN)) {
            try {
                startIntent(context, PACKAGE_HUAWEI_MAIN, PACKAGE_HUAWEI_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    startIntent(context, PACKAGE_HUAWEI_MAIN, PACKAGE_HUAWEI_COMPONENT_FALLBACK);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartOppo(Context context) {
        if (isPackageExists(context, PACKAGE_OPPO_MAIN) || isPackageExists(context, PACKAGE_OPPO_FALLBACK)) {
            try {
                startIntent(context, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    startIntent(context, PACKAGE_OPPO_FALLBACK, PACKAGE_OPPO_COMPONENT_FALLBACK);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    try {
                        startIntent(context, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT_FALLBACK_A);
                    } catch (Exception exx) {
                        exx.printStackTrace();
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartVivo(Context context) {
        if (isPackageExists(context, PACKAGE_VIVO_MAIN) || isPackageExists(context, PACKAGE_VIVO_FALLBACK)) {
            try {
                startIntent(context, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    startIntent(context, PACKAGE_VIVO_FALLBACK, PACKAGE_VIVO_COMPONENT_FALLBACK);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    try {
                        startIntent(context, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT_FALLBACK_A);
                    } catch (Exception exx) {
                        exx.printStackTrace();
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartNokia(Context context) {
        if (isPackageExists(context, PACKAGE_NOKIA_MAIN)) {
            try {
                startIntent(context, PACKAGE_NOKIA_MAIN, PACKAGE_NOKIA_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartSamsung(Context context) {
        if (isPackageExists(context, PACKAGE_SAMSUNG_MAIN)) {
            try {
                startIntent(context, PACKAGE_SAMSUNG_MAIN, PACKAGE_SAMSUNG_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean autoStartOnePlus(Context context) {
        if (isPackageExists(context, PACKAGE_ONE_PLUS_MAIN)) {
            try {
                startIntent(context, PACKAGE_ONE_PLUS_MAIN, PACKAGE_ONE_PLUS_COMPONENT);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private void startIntent(Context context, String packageName, String componentName) throws Exception {
        try {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(new ComponentName(packageName, componentName));
            context.startActivity(intent);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    private boolean isPackageExists(Context context, String targetPackage) {
        List<ApplicationInfo> packages;
        packages = context.getPackageManager().getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if (packageInfo.packageName.equals(targetPackage)) {
                return true;
            }
        }
        return false;
    }
}