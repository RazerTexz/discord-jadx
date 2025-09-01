package com.discord.widgets.chat.input.emoji;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetEmojiPickerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiPickerSheet;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerSheet;", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "", "cancelDialog", "()V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/models/domain/emoji/Emoji;", "emoji", "onEmojiPicked", "(Lcom/discord/models/domain/emoji/Emoji;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "emojiPickerListener", "setEmojiPickerListener", "(Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;)V", "emojiPickerListenerDelegate", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiPicker;", "emojiPickerFragment", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiPicker;", "container", "Landroid/view/View;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEmojiPickerSheet extends WidgetExpressionPickerSheet implements EmojiPickerListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetEmojiPicker emojiPickerFragment;
    private EmojiPickerListener emojiPickerListenerDelegate;

    /* compiled from: WidgetEmojiPickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiPickerSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "emojiPickerListener", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;", "emojiPickerContextType", "Lkotlin/Function0;", "", "onCancel", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0 function0, int i, Object obj) {
            if ((i & 8) != 0) {
                function0 = null;
            }
            companion.show(fragmentManager, emojiPickerListener, emojiPickerContextType, function0);
        }

        public final void show(FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0<Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
            WidgetEmojiPickerSheet widgetEmojiPickerSheet = new WidgetEmojiPickerSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE, emojiPickerContextType);
            widgetEmojiPickerSheet.setArguments(bundle);
            widgetEmojiPickerSheet.setEmojiPickerListener(emojiPickerListener);
            widgetEmojiPickerSheet.setOnCancel(onCancel);
            widgetEmojiPickerSheet.show(fragmentManager, WidgetEmojiPickerSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEmojiPickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPickerSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams layoutParams = WidgetEmojiPickerSheet.access$getContainer$p(WidgetEmojiPickerSheet.this).getLayoutParams();
            if (layoutParams != null) {
                Intrinsics3.checkNotNullExpressionValue(WidgetEmojiPickerSheet.this.getResources(), "resources");
                layoutParams.height = (int) (r1.getDisplayMetrics().heightPixels * 0.9d);
            }
        }
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetEmojiPickerSheet widgetEmojiPickerSheet) {
        View view = widgetEmojiPickerSheet.container;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetEmojiPickerSheet widgetEmojiPickerSheet, View view) {
        widgetEmojiPickerSheet.container = view;
    }

    private final void cancelDialog() {
        WidgetEmojiPicker widgetEmojiPicker = this.emojiPickerFragment;
        if (widgetEmojiPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        widgetEmojiPicker.clearSearchInput();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_emoji_picker_sheet;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        cancelDialog();
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        EmojiPickerListener emojiPickerListener = this.emojiPickerListenerDelegate;
        if (emojiPickerListener != null) {
            emojiPickerListener.onEmojiPicked(emoji);
        }
        cancelDialog();
        dismiss();
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.container = view;
        WidgetEmojiPicker widgetEmojiPicker = new WidgetEmojiPicker();
        this.emojiPickerFragment = widgetEmojiPicker;
        if (widgetEmojiPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", EmojiPickerMode.BOTTOM_SHEET);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE) : null;
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiPickerContextType");
        bundle.putSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE, (EmojiPickerContextType) serializable);
        widgetEmojiPicker.setArguments(bundle);
        WidgetEmojiPicker widgetEmojiPicker2 = this.emojiPickerFragment;
        if (widgetEmojiPicker2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        widgetEmojiPicker2.setListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetEmojiPicker widgetEmojiPicker3 = this.emojiPickerFragment;
        if (widgetEmojiPicker3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        WidgetEmojiPicker widgetEmojiPicker4 = this.emojiPickerFragment;
        if (widgetEmojiPicker4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R.id.emoji_sheet_emoji_picker_content, widgetEmojiPicker3, widgetEmojiPicker4.getClass().getSimpleName()).runOnCommit(new AnonymousClass2()).commit();
    }

    public final void setEmojiPickerListener(EmojiPickerListener emojiPickerListener) {
        this.emojiPickerListenerDelegate = emojiPickerListener;
    }
}
