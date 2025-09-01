package com.discord.widgets.chat.input.gifpicker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGifPickerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\t2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0010\u0010\u0014R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/WidgetGifPickerSheet;", "Lcom/discord/app/AppBottomSheet;", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function0;", "onGifSelected", "setOnGifSelected", "(Lkotlin/jvm/functions/Function0;)V", "onCancel", "setOnCancel", "Landroid/content/DialogInterface;", "dialog", "(Landroid/content/DialogInterface;)V", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/widgets/chat/input/gifpicker/WidgetGifPickerSearch;", "gifPickerFragment", "Lcom/discord/widgets/chat/input/gifpicker/WidgetGifPickerSearch;", "container", "Landroid/view/View;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGifPickerSheet extends AppBottomSheet {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetGifPickerSearch gifPickerFragment;
    private Function0<Unit> onCancel;
    private Function0<Unit> onGifSelected;

    /* compiled from: WidgetGifPickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/WidgetGifPickerSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "", "onGifSelected", "onCancel", "show", "(Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Function0 function0, Function0 function02, int i, Object obj) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            if ((i & 4) != 0) {
                function02 = null;
            }
            companion.show(fragmentManager, function0, function02);
        }

        public final void show(FragmentManager fragmentManager, Function0<Unit> onGifSelected, Function0<Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGifPickerSheet widgetGifPickerSheet = new WidgetGifPickerSheet();
            widgetGifPickerSheet.show(fragmentManager, WidgetGifPickerSheet.class.getSimpleName());
            widgetGifPickerSheet.setOnGifSelected(onGifSelected);
            widgetGifPickerSheet.setOnCancel(onCancel);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGifPickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0Access$getOnGifSelected$p = WidgetGifPickerSheet.access$getOnGifSelected$p(WidgetGifPickerSheet.this);
            if (function0Access$getOnGifSelected$p != null) {
            }
            WidgetGifPickerSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetGifPickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams layoutParams = WidgetGifPickerSheet.access$getContainer$p(WidgetGifPickerSheet.this).getLayoutParams();
            if (layoutParams != null) {
                Intrinsics3.checkNotNullExpressionValue(WidgetGifPickerSheet.this.getResources(), "resources");
                layoutParams.height = (int) (r1.getDisplayMetrics().heightPixels * 0.9d);
            }
        }
    }

    public WidgetGifPickerSheet() {
        super(false, 1, null);
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetGifPickerSheet widgetGifPickerSheet) {
        View view = widgetGifPickerSheet.container;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ Function0 access$getOnGifSelected$p(WidgetGifPickerSheet widgetGifPickerSheet) {
        return widgetGifPickerSheet.onGifSelected;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetGifPickerSheet widgetGifPickerSheet, View view) {
        widgetGifPickerSheet.container = view;
    }

    public static final /* synthetic */ void access$setOnGifSelected$p(WidgetGifPickerSheet widgetGifPickerSheet, Function0 function0) {
        widgetGifPickerSheet.onGifSelected = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCancel$default(WidgetGifPickerSheet widgetGifPickerSheet, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        widgetGifPickerSheet.setOnCancel(function0);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_gif_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetGifPickerSearch widgetGifPickerSearch = this.gifPickerFragment;
        if (widgetGifPickerSearch == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.clearSearchBar();
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        this.container = view;
        WidgetGifPickerSearch widgetGifPickerSearch = new WidgetGifPickerSearch();
        this.gifPickerFragment = widgetGifPickerSearch;
        if (widgetGifPickerSearch == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.setOnGifSelected(new AnonymousClass1());
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetGifPickerSearch widgetGifPickerSearch2 = this.gifPickerFragment;
        if (widgetGifPickerSearch2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        WidgetGifPickerSearch widgetGifPickerSearch3 = this.gifPickerFragment;
        if (widgetGifPickerSearch3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R.id.gif_search_sheet_content, widgetGifPickerSearch2, widgetGifPickerSearch3.getClass().getSimpleName()).runOnCommit(new AnonymousClass2()).commit();
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }

    public final void setOnGifSelected(Function0<Unit> onGifSelected) {
        this.onGifSelected = onGifSelected;
    }
}
