package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import com.discord.app.AppFragment;
import com.discord.utilities.view.text.TextWatcher4;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatInputTruncatedHint.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputTruncatedHint;", "", "", "syncHint", "()V", "Lcom/discord/app/AppFragment;", "fragment", "addBindedTextWatcher", "(Lcom/discord/app/AppFragment;)V", "", "hint", "setHint", "(Ljava/lang/CharSequence;)V", "Ljava/lang/CharSequence;", "", "hintIsTruncated", "Z", "", "previousMaxLines", "I", "Lcom/lytefast/flexinput/widget/FlexEditText;", "editText", "Lcom/lytefast/flexinput/widget/FlexEditText;", "getEditText", "()Lcom/lytefast/flexinput/widget/FlexEditText;", "<init>", "(Lcom/lytefast/flexinput/widget/FlexEditText;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputTruncatedHint {
    private final FlexEditText editText;
    private CharSequence hint;
    private boolean hintIsTruncated;
    private int previousMaxLines;

    /* compiled from: WidgetChatInputTruncatedHint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "maxLines", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            if (WidgetChatInputTruncatedHint.access$getHintIsTruncated$p(WidgetChatInputTruncatedHint.this)) {
                return;
            }
            WidgetChatInputTruncatedHint.access$setPreviousMaxLines$p(WidgetChatInputTruncatedHint.this, i);
        }
    }

    /* compiled from: WidgetChatInputTruncatedHint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$addBindedTextWatcher$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetChatInputTruncatedHint.access$syncHint(WidgetChatInputTruncatedHint.this);
        }
    }

    public WidgetChatInputTruncatedHint(FlexEditText flexEditText) {
        Intrinsics3.checkNotNullParameter(flexEditText, "editText");
        this.editText = flexEditText;
        this.previousMaxLines = flexEditText.getMaxLines();
        flexEditText.setOnMaxLinesChangedListener(new AnonymousClass1());
    }

    public static final /* synthetic */ boolean access$getHintIsTruncated$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        return widgetChatInputTruncatedHint.hintIsTruncated;
    }

    public static final /* synthetic */ int access$getPreviousMaxLines$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        return widgetChatInputTruncatedHint.previousMaxLines;
    }

    public static final /* synthetic */ void access$setHintIsTruncated$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint, boolean z2) {
        widgetChatInputTruncatedHint.hintIsTruncated = z2;
    }

    public static final /* synthetic */ void access$setPreviousMaxLines$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint, int i) {
        widgetChatInputTruncatedHint.previousMaxLines = i;
    }

    public static final /* synthetic */ void access$syncHint(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        widgetChatInputTruncatedHint.syncHint();
    }

    private final void syncHint() {
        boolean z2 = this.editText.length() == 0;
        this.hintIsTruncated = z2;
        if (z2) {
            this.editText.setMaxLines(1);
            this.editText.setEllipsize(TextUtils.TruncateAt.END);
            this.editText.setHint(this.hint);
        } else {
            this.editText.setMaxLines(this.previousMaxLines);
            this.editText.setEllipsize(null);
            this.editText.setHint((CharSequence) null);
        }
    }

    public final void addBindedTextWatcher(AppFragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        TextWatcher4.addBindedTextWatcher(this.editText, fragment, new AnonymousClass1());
    }

    public final FlexEditText getEditText() {
        return this.editText;
    }

    public final void setHint(CharSequence hint) {
        Intrinsics3.checkNotNullParameter(hint, "hint");
        this.hint = hint;
        syncHint();
    }
}
