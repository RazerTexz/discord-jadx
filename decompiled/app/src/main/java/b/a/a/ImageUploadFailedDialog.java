package b.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.ImageUploadFailedDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.SendUtils2;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ImageUploadFailedDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lb/a/a/c;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lb/a/i/c0;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/c0;", "binding", "Lkotlin/Function0;", "m", "Lkotlin/jvm/functions/Function0;", "onResendCompressed", "<init>", "()V", "k", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.c, reason: use source file name */
/* loaded from: classes.dex */
public final class ImageUploadFailedDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(ImageUploadFailedDialog.class, "binding", "getBinding()Lcom/discord/databinding/ImageUploadFailedDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onResendCompressed;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.c$a */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                Function0<Unit> function0 = ((ImageUploadFailedDialog) this.k).onResendCompressed;
                if (function0 != null) {
                    function0.invoke();
                }
                ((ImageUploadFailedDialog) this.k).dismiss();
                return;
            }
            if (i == 1) {
                ((ImageUploadFailedDialog) this.k).dismiss();
                return;
            }
            if (i == 2) {
                ((ImageUploadFailedDialog) this.k).dismiss();
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    throw null;
                }
                ImageUploadFailedDialog imageUploadFailedDialog = (ImageUploadFailedDialog) this.k;
                KProperty[] kPropertyArr = ImageUploadFailedDialog.j;
                imageUploadFailedDialog.g().c.toggle();
                return;
            }
            AnalyticsTracker.INSTANCE.premiumSettingsOpened(new Traits.Location(null, "File Upload Popout (w/ Compression)", null, null, null, 29, null));
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
            ((ImageUploadFailedDialog) this.k).dismiss();
        }
    }

    /* compiled from: ImageUploadFailedDialog.kt */
    /* renamed from: b.a.a.c$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(FragmentManager fragmentManager, boolean z2, int i, float f, float f2, Function0<Unit> function0, int i2, boolean z3, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            float f3 = 1048576;
            StoreStream.INSTANCE.getAnalytics().trackFileUploadAlertViewed(z2 ? SendUtils2.OVER_MAX_SIZE : SendUtils2.NITRO_UPSELL, i2, (int) (f * f3), (int) (f3 * f2), z3, z4, z2);
            ImageUploadFailedDialog imageUploadFailedDialog = new ImageUploadFailedDialog();
            imageUploadFailedDialog.onResendCompressed = function0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_IS_USER_PREMIUM", z2);
            bundle.putBoolean("PARAM_CAN_COMPRESS", (z4 || z5) ? false : true);
            bundle.putInt("PARAM_MAX_FILE_SIZE_MB", i);
            imageUploadFailedDialog.setArguments(bundle);
            imageUploadFailedDialog.show(fragmentManager, ImageUploadDialog.class.getName());
        }
    }

    /* compiled from: ImageUploadFailedDialog.kt */
    /* renamed from: b.a.a.c$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, ImageUploadFailedDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, ImageUploadFailedDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ImageUploadFailedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public ImageUploadFailedDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.chat_input_upload_too_large_center_file;
            ImageView imageView = (ImageView) view2.findViewById(R.id.chat_input_upload_too_large_center_file);
            if (imageView != null) {
                i = R.id.image_upload_failed_cancel;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.image_upload_failed_cancel);
                if (materialButton != null) {
                    i = R.id.image_upload_failed_compression_settings_checkbox;
                    SwitchMaterial switchMaterial = (SwitchMaterial) view2.findViewById(R.id.image_upload_failed_compression_settings_checkbox);
                    if (switchMaterial != null) {
                        i = R.id.image_upload_failed_compression_settings_container;
                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.image_upload_failed_compression_settings_container);
                        if (relativeLayout != null) {
                            i = R.id.image_upload_failed_divider;
                            View viewFindViewById = view2.findViewById(R.id.image_upload_failed_divider);
                            if (viewFindViewById != null) {
                                i = R.id.image_upload_failed_nitro;
                                MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.image_upload_failed_nitro);
                                if (materialButton2 != null) {
                                    i = R.id.image_upload_failed_nitro_wrapper;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.image_upload_failed_nitro_wrapper);
                                    if (relativeLayout2 != null) {
                                        i = R.id.image_upload_failed_okay;
                                        MaterialButton materialButton3 = (MaterialButton) view2.findViewById(R.id.image_upload_failed_okay);
                                        if (materialButton3 != null) {
                                            i = R.id.image_upload_failed_send_compress;
                                            MaterialButton materialButton4 = (MaterialButton) view2.findViewById(R.id.image_upload_failed_send_compress);
                                            if (materialButton4 != null) {
                                                i = R.id.image_upload_failed_text;
                                                TextView textView = (TextView) view2.findViewById(R.id.image_upload_failed_text);
                                                if (textView != null) {
                                                    i = R.id.setting_label;
                                                    TextView textView2 = (TextView) view2.findViewById(R.id.setting_label);
                                                    if (textView2 != null) {
                                                        i = R.id.setting_subtext;
                                                        TextView textView3 = (TextView) view2.findViewById(R.id.setting_subtext);
                                                        if (textView3 != null) {
                                                            return new ImageUploadFailedDialogBinding((RelativeLayout) view2, imageView, materialButton, switchMaterial, relativeLayout, viewFindViewById, materialButton2, relativeLayout2, materialButton3, materialButton4, textView, textView2, textView3);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: ImageUploadFailedDialog.kt */
    /* renamed from: b.a.a.c$d */
    public static final class d implements CompoundButton.OnCheckedChangeListener {
        public static final d a = new d();

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            StoreStream.INSTANCE.getUserSettings().setIsAutoImageCompressionEnabled(z2);
        }
    }

    public ImageUploadFailedDialog() {
        super(R.layout.image_upload_failed_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final ImageUploadFailedDialogBinding g() {
        return (ImageUploadFailedDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int i = getArgumentsOrDefault().getInt("PARAM_MAX_FILE_SIZE_MB");
        boolean z2 = getArgumentsOrDefault().getBoolean("PARAM_IS_USER_PREMIUM");
        boolean z3 = this.onResendCompressed != null && getArgumentsOrDefault().getBoolean("PARAM_CAN_COMPRESS");
        int i2 = i != 8 ? i != 20 ? i != 50 ? i != 100 ? 0 : R.string.file_upload_limit_premium_tier_2 : R.string.file_upload_limit_premium_tier_1 : R.string.file_upload_limit_premium_tier_0 : R.string.file_upload_limit_standard;
        MaterialButton materialButton = g().i;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.imageUploadFailedSendCompress");
        materialButton.setVisibility(z3 ? 0 : 8);
        g().i.setOnClickListener(new a(0, this));
        boolean z4 = z2 && !z3;
        View view2 = g().e;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.imageUploadFailedDivider");
        boolean z5 = !z4;
        view2.setVisibility(z5 ? 0 : 8);
        MaterialButton materialButton2 = g().h;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.imageUploadFailedOkay");
        materialButton2.setVisibility(z4 ? 0 : 8);
        g().h.setOnClickListener(new a(1, this));
        MaterialButton materialButton3 = g().f89b;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.imageUploadFailedCancel");
        materialButton3.setVisibility(z5 ? 0 : 8);
        g().f89b.setOnClickListener(new a(2, this));
        RelativeLayout relativeLayout = g().g;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.imageUploadFailedNitroWrapper");
        relativeLayout.setVisibility(z2 ^ true ? 0 : 8);
        g().f.setOnClickListener(new a(3, this));
        RelativeLayout relativeLayout2 = g().d;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.imageUploadFaile…pressionSettingsContainer");
        relativeLayout2.setVisibility(z3 ? 0 : 8);
        g().d.setOnClickListener(new a(4, this));
        SwitchMaterial switchMaterial = g().c;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.imageUploadFaile…mpressionSettingsCheckbox");
        switchMaterial.setChecked(StoreStream.INSTANCE.getUserSettings().getIsAutoImageCompressionEnabled());
        g().c.setOnCheckedChangeListener(d.a);
        TextView textView = g().j;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.imageUploadFailedText");
        CharSequence charSequenceH = null;
        if (z2 || !z3) {
            Context context = getContext();
            if (context != null) {
                Object[] objArr = new Object[1];
                Context context2 = getContext();
                objArr[0] = context2 != null ? FormatUtils.h(context2, i2, new Object[0], null, 4) : null;
                charSequenceH = FormatUtils.h(context, R.string.upload_area_too_large_help, objArr, null, 4);
            }
        } else {
            Context context3 = getContext();
            if (context3 != null) {
                Object[] objArr2 = new Object[1];
                Context context4 = getContext();
                objArr2[0] = context4 != null ? FormatUtils.h(context4, i2, new Object[0], null, 4) : null;
                charSequenceH = FormatUtils.h(context3, R.string.upload_area_too_large_help_mobile, objArr2, null, 4);
            }
        }
        textView.setText(charSequenceH);
    }
}
