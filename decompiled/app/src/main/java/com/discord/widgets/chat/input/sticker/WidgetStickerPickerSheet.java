package com.discord.widgets.chat.input.sticker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetStickerPickerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\n2\u000e\u0010\u001b\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/sticker/WidgetStickerPickerSheet;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerSheet;", "Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/api/sticker/Sticker;", "sticker", "onStickerPicked", "(Lcom/discord/api/sticker/Sticker;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "onDismiss", "stickerPickerListener", "setStickerPickerListener", "(Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;)V", "", "Lcom/discord/primitives/StickerPackId;", "packId", "scrollToPack", "(Ljava/lang/Long;)V", "stickerPickerListenerDelegate", "Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerPicker;", "stickerPickerFragment", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerPicker;", "container", "Landroid/view/View;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStickerPickerSheet extends WidgetExpressionPickerSheet implements StickerPickerListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetStickerPicker stickerPickerFragment;
    private StickerPickerListener stickerPickerListenerDelegate;

    /* compiled from: WidgetStickerPickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JO\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/WidgetStickerPickerSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;", "stickerPickerListener", "", "Lcom/discord/primitives/StickerPackId;", "initialStickerPackId", "", "searchText", "Lkotlin/Function0;", "", "onCancel", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerPickerSheet;", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;Ljava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/discord/widgets/chat/input/sticker/WidgetStickerPickerSheet;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetStickerPickerSheet show$default(Companion companion, FragmentManager fragmentManager, StickerPickerListener stickerPickerListener, Long l, String str, Function0 function0, int i, Object obj) {
            return companion.show(fragmentManager, stickerPickerListener, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : function0);
        }

        public final WidgetStickerPickerSheet show(FragmentManager fragmentManager, StickerPickerListener stickerPickerListener, Long initialStickerPackId, String searchText, Function0<Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            System.gc();
            Bundle bundle = new Bundle();
            if (initialStickerPackId != null) {
                initialStickerPackId.longValue();
                bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", initialStickerPackId.longValue());
            }
            bundle.putString("com.discord.intent.extra.EXTRA_TEXT", searchText);
            WidgetStickerPickerSheet widgetStickerPickerSheet = new WidgetStickerPickerSheet();
            widgetStickerPickerSheet.setStickerPickerListener(stickerPickerListener);
            widgetStickerPickerSheet.setOnCancel(onCancel);
            widgetStickerPickerSheet.setArguments(bundle);
            widgetStickerPickerSheet.show(fragmentManager, WidgetStickerPickerSheet.class.getSimpleName());
            return widgetStickerPickerSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStickerPickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPickerSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams layoutParams = WidgetStickerPickerSheet.access$getContainer$p(WidgetStickerPickerSheet.this).getLayoutParams();
            if (layoutParams != null) {
                Intrinsics3.checkNotNullExpressionValue(WidgetStickerPickerSheet.this.getResources(), "resources");
                layoutParams.height = (int) (r1.getDisplayMetrics().heightPixels * 0.9d);
            }
        }
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetStickerPickerSheet widgetStickerPickerSheet) {
        View view = widgetStickerPickerSheet.container;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetStickerPickerSheet widgetStickerPickerSheet, View view) {
        widgetStickerPickerSheet.container = view;
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_sticker_picker_sheet;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.clearSearchInput();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.selectCategoryById(-1L);
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
    public void onStickerPicked(Sticker sticker) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        StickerPickerListener stickerPickerListener = this.stickerPickerListenerDelegate;
        if (stickerPickerListener != null) {
            stickerPickerListener.onStickerPicked(sticker);
        }
        dismiss();
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.container = view;
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("com.discord.intent.EXTRA_STICKER_PICKER_SCREEN") : null;
        Bundle arguments3 = getArguments();
        String string = arguments3 != null ? arguments3.getString("com.discord.intent.extra.EXTRA_TEXT") : null;
        WidgetStickerPicker widgetStickerPicker = new WidgetStickerPicker();
        this.stickerPickerFragment = widgetStickerPicker;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", StickerPickerMode.BOTTOM_SHEET);
        bundle.putSerializable(WidgetStickerPicker.VIEW_TYPE, WidgetStickerPackStoreSheet2.STICKER_SEARCH_VIEW_ALL);
        bundle.putString("com.discord.intent.extra.EXTRA_TEXT", string);
        if (lValueOf != null) {
            bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", lValueOf.longValue());
        }
        if (serializable != null) {
            bundle.putSerializable("com.discord.intent.EXTRA_STICKER_PICKER_SCREEN", serializable);
        }
        widgetStickerPicker.setArguments(bundle);
        WidgetStickerPicker widgetStickerPicker2 = this.stickerPickerFragment;
        if (widgetStickerPicker2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker2.setListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetStickerPicker widgetStickerPicker3 = this.stickerPickerFragment;
        if (widgetStickerPicker3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        WidgetStickerPicker widgetStickerPicker4 = this.stickerPickerFragment;
        if (widgetStickerPicker4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R.id.sticker_sheet_sticker_picker_content, widgetStickerPicker3, widgetStickerPicker4.getClass().getSimpleName()).runOnCommit(new AnonymousClass2()).commit();
    }

    public final void scrollToPack(Long packId) {
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.scrollToPack(packId);
    }

    public final void setStickerPickerListener(StickerPickerListener stickerPickerListener) {
        this.stickerPickerListenerDelegate = stickerPickerListener;
    }
}
