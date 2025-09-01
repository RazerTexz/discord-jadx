package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    /* renamed from: androidx.appcompat.widget.AppCompatDrawableManager$1, reason: invalid class name */
    public class AnonymousClass1 implements ResourceManagerInternal.ResourceManagerHooks {
        private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
        private final int[] TINT_COLOR_CONTROL_NORMAL = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
        private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        private final int[] TINT_COLOR_CONTROL_STATE_LIST = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        private final int[] TINT_CHECKABLE_BUTTON_LIST = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        private boolean arrayContains(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList createBorderlessButtonColorStateList(@NonNull Context context) {
            return createButtonColorStateList(context, 0);
        }

        private ColorStateList createButtonColorStateList(@NonNull Context context, @ColorInt int i) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
        }

        private ColorStateList createColoredButtonColorStateList(@NonNull Context context) {
            return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
        }

        private ColorStateList createDefaultButtonColorStateList(@NonNull Context context) {
            return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
        }

        private ColorStateList createSwitchThumbColorStateList(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i = R.attr.colorSwitchThumbNormal;
            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, i);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, i);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = ThemeUtils.getThemeAttrColor(context, i);
            } else {
                iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = AppCompatDrawableManager.access$000();
            }
            drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i) {
            if (i == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public ColorStateList getTintListForDrawableRes(@NonNull Context context, int i) {
            if (i == R.drawable.abc_edit_text_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i == R.drawable.abc_switch_thumb_material) {
                return createSwitchThumbColorStateList(context);
            }
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return createDefaultButtonColorStateList(context);
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return createBorderlessButtonColorStateList(context);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return createColoredButtonColorStateList(context);
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
            }
            if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
            }
            if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
            }
            if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public PorterDuff.Mode getTintModeForDrawableRes(int i) {
            if (i == R.drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public boolean tintDrawable(@NonNull Context context, int i, @NonNull Drawable drawable) {
            if (i == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int i2 = R.attr.colorControlNormal;
                setPorterDuffColorFilter(drawableFindDrawableByLayerId, ThemeUtils.getThemeAttrColor(context, i2), AppCompatDrawableManager.access$000());
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, i2), AppCompatDrawableManager.access$000());
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.access$000());
                return true;
            }
            if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.background), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.access$000());
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
            int i3 = R.attr.colorControlActivated;
            setPorterDuffColorFilter(drawableFindDrawableByLayerId2, ThemeUtils.getThemeAttrColor(context, i3), AppCompatDrawableManager.access$000());
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, i3), AppCompatDrawableManager.access$000());
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean tintDrawableUsingColorFilter(@NonNull Context context, int i, @NonNull Drawable drawable) {
            int iRound;
            boolean z2;
            PorterDuff.Mode modeAccess$000 = AppCompatDrawableManager.access$000();
            boolean zArrayContains = arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i);
            int i2 = android.R.attr.colorBackground;
            if (zArrayContains) {
                i2 = R.attr.colorControlNormal;
            } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                i2 = R.attr.colorControlActivated;
            } else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                modeAccess$000 = PorterDuff.Mode.MULTIPLY;
            } else {
                if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                    i2 = android.R.attr.colorForeground;
                    iRound = Math.round(40.8f);
                    z2 = true;
                    if (!z2) {
                        return false;
                    }
                    if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), modeAccess$000));
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
                if (i != R.drawable.abc_dialog_material_background) {
                    iRound = -1;
                    z2 = false;
                    i2 = 0;
                    if (!z2) {
                    }
                }
            }
            iRound = -1;
            z2 = true;
            if (!z2) {
            }
        }
    }

    public static /* synthetic */ PorterDuff.Mode access$000() {
        return DEFAULT_MODE;
    }

    public static synchronized AppCompatDrawableManager get() {
        if (INSTANCE == null) {
            preload();
        }
        return INSTANCE;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        return ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
    }

    public static synchronized void preload() {
        if (INSTANCE == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            INSTANCE = appCompatDrawableManager;
            appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
            INSTANCE.mResourceManager.setHooks(new AnonymousClass1());
        }
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return this.mResourceManager.getDrawable(context, i);
    }

    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i) {
        return this.mResourceManager.getTintList(context, i);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }

    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i);
    }

    public boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i, boolean z2) {
        return this.mResourceManager.getDrawable(context, i, z2);
    }
}
