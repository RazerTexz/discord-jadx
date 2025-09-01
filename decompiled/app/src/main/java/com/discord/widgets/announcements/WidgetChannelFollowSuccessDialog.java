package com.discord.widgets.announcements;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetChannelFollowSuccessDialogBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.c0.Random;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetChannelFollowSuccessDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSuccessDialog;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "", "", "successImageOptions", "[Ljava/lang/Integer;", "Lcom/discord/databinding/WidgetChannelFollowSuccessDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelFollowSuccessDialogBinding;", "binding", "successTextOptions", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelFollowSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelFollowSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSuccessDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Integer[] successImageOptions;
    private final Integer[] successTextOptions;

    /* compiled from: WidgetChannelFollowSuccessDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSuccessDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "show", "(Landroidx/fragment/app/FragmentManager;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetChannelFollowSuccessDialog().show(fragmentManager, WidgetChannelFollowSuccessDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelFollowSuccessDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSuccessDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelFollowSuccessDialog.this.dismiss();
        }
    }

    public WidgetChannelFollowSuccessDialog() {
        super(R.layout.widget_channel_follow_success_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelFollowSuccessDialog2.INSTANCE, null, 2, null);
        this.successTextOptions = new Integer[]{Integer.valueOf(R.string.follow_success_modal_header_01), Integer.valueOf(R.string.follow_success_modal_header_02), Integer.valueOf(R.string.follow_success_modal_header_03), Integer.valueOf(R.string.follow_success_modal_header_04), Integer.valueOf(R.string.follow_success_modal_header_05), Integer.valueOf(R.string.follow_success_modal_header_06), Integer.valueOf(R.string.follow_success_modal_header_07), Integer.valueOf(R.string.follow_success_modal_header_08), Integer.valueOf(R.string.follow_success_modal_header_09), Integer.valueOf(R.string.follow_success_modal_header_10)};
        this.successImageOptions = new Integer[]{Integer.valueOf(R.attr.img_channel_following_success_1), Integer.valueOf(R.attr.img_channel_following_success_2), Integer.valueOf(R.attr.img_channel_following_success_3)};
    }

    private final WidgetChannelFollowSuccessDialogBinding getBinding() {
        return (WidgetChannelFollowSuccessDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        INSTANCE.show(fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowSuccessText");
        Integer[] numArr = this.successTextOptions;
        Random.a aVar = Random.k;
        textView.setText(getString(((Number) _Arrays.random(numArr, aVar)).intValue()));
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowSuccessImage");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        MGImages.setImage$default(mGImages, simpleDraweeView, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, ((Number) _Arrays.random(this.successImageOptions, aVar)).intValue(), 0, 2, (Object) null), (MGImages.ChangeDetector) null, 4, (Object) null);
        getBinding().f2256b.setOnClickListener(new AnonymousClass1());
    }
}
