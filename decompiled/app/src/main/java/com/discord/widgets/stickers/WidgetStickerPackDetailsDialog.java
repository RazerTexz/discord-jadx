package com.discord.widgets.stickers;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStickerPackDetailsDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001a\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/stickers/WidgetStickerPackDetailsDialog;", "Lcom/discord/app/AppDialog;", "Lcom/discord/stores/StoreStickers$StickerPackState;", "stickerPackState", "", "configureUI", "(Lcom/discord/stores/StoreStickers$StickerPackState;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/StickerPackDetailsDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/StickerPackDetailsDialogBinding;", "binding", "", "Lcom/discord/primitives/StickerPackId;", "stickerPackId", "Ljava/lang/Long;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetStickerPackDetailsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStickerPackDetailsDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_Y_POSITION = "EXTRA_Y_POSITION";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Long stickerPackId;

    /* compiled from: WidgetStickerPackDetailsDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/stickers/WidgetStickerPackDetailsDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/StickerPackId;", "stickerPackId", "", "y", "", "show", "(Landroidx/fragment/app/FragmentManager;JLjava/lang/Integer;)V", "", WidgetStickerPackDetailsDialog.EXTRA_Y_POSITION, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                num = null;
            }
            companion.show(fragmentManager, j, num);
        }

        public final void show(FragmentManager fragmentManager, long stickerPackId, Integer y2) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", stickerPackId);
            if (y2 != null) {
                y2.intValue();
                bundle.putInt(WidgetStickerPackDetailsDialog.EXTRA_Y_POSITION, y2.intValue());
            }
            WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog = new WidgetStickerPackDetailsDialog();
            widgetStickerPackDetailsDialog.setArguments(bundle);
            widgetStickerPackDetailsDialog.show(fragmentManager, WidgetStickerPackDetailsDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStickerPackDetailsDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStickerPackDetailsDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetStickerPackDetailsDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState;", "it", "", "invoke", "(Lcom/discord/stores/StoreStickers$StickerPackState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreStickers.StickerPackState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreStickers.StickerPackState stickerPackState) {
            invoke2(stickerPackState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreStickers.StickerPackState stickerPackState) {
            Intrinsics3.checkNotNullParameter(stickerPackState, "it");
            WidgetStickerPackDetailsDialog.access$configureUI(WidgetStickerPackDetailsDialog.this, stickerPackState);
        }
    }

    public WidgetStickerPackDetailsDialog() {
        super(R.layout.sticker_pack_details_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerPackDetailsDialog2.INSTANCE, null, 2, null);
        setStyle(1, 2131951655);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog, StoreStickers.StickerPackState stickerPackState) {
        widgetStickerPackDetailsDialog.configureUI(stickerPackState);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureUI(StoreStickers.StickerPackState stickerPackState) {
        if (stickerPackState instanceof StoreStickers.StickerPackState.Loaded) {
            ModelStickerPack stickerPack = ((StoreStickers.StickerPackState.Loaded) stickerPackState).getStickerPack();
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerPackDetailsPack");
            textView.setText(FormatUtils.k(this, R.string.sticker_picker_pack_details, new Object[]{stickerPack.getName()}, null, 4));
            TextView textView2 = getBinding().f2152b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stickerPackDetailsAnimated");
            textView2.setVisibility(stickerPack.isAnimatedPack() ? 0 : 8);
            TextView textView3 = getBinding().f2152b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.stickerPackDetailsAnimated");
            textView3.setText("・ " + getString(R.string.sticker_picker_pack_details_animated));
            TextView textView4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.stickerPackDetailsPremium");
            textView4.setVisibility(stickerPack.isPremiumPack() ? 0 : 8);
            TextView textView5 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.stickerPackDetailsPremium");
            textView5.setText("・ " + getString(R.string.sticker_picker_pack_details_premium));
            TextView textView6 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.stickerPackDetailsLimited");
            textView6.setVisibility(stickerPack.isLimitedPack() ? 0 : 8);
            TextView textView7 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.stickerPackDetailsLimited");
            StringBuilder sb = new StringBuilder();
            sb.append("・ ");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            sb.append(FormatUtils.k(this, R.string.sticker_picker_pack_details_limited_time_left, new Object[]{stickerUtils.getLimitedTimeLeftString(contextRequireContext, stickerPack.getStoreListing())}, null, 4));
            textView7.setText(sb.toString());
        }
    }

    private final StickerPackDetailsDialogBinding getBinding() {
        return (StickerPackDetailsDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes;
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setGravity(81);
        }
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt(EXTRA_Y_POSITION, 0)) : null;
        Window window2 = dialogOnCreateDialog.getWindow();
        if (window2 != null && (attributes = window2.getAttributes()) != null) {
            if (numValueOf != null && numValueOf.intValue() == 0) {
                Context context = dialogOnCreateDialog.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                numValueOf = Integer.valueOf((int) (context.getResources().getDimension(R.dimen.default_keyboard_height) / 2));
            }
            attributes.y = numValueOf.intValue();
        }
        return dialogOnCreateDialog;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        this.stickerPackId = lValueOf;
        if (lValueOf != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getStickers().observeStickerPack(lValueOf.longValue()), this, null, 2, null), WidgetStickerPackDetailsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        }
    }
}
