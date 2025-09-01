package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.chat.input.MessageDraftsRepo;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* compiled from: WidgetChatInputEditText.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u000b\u0010 R\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputEditText;", "", "", "setOnTextChangedListener", "()V", "setSoftwareKeyboardSendBehavior", "setHardwareKeyboardSendBehavior", "", "channelId", "", "saveExistingText", "setChannelId", "(JZ)V", "saveText", "clearLastTypingEmission", "", "getText", "()Ljava/lang/String;", "Lkotlin/Function0;", "onSendListener", "Lkotlin/jvm/functions/Function0;", "getOnSendListener", "()Lkotlin/jvm/functions/Function0;", "setOnSendListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/lytefast/flexinput/widget/FlexEditText;", "editText", "Lcom/lytefast/flexinput/widget/FlexEditText;", "lastTypingEmissionMillis", "J", "getChannelId", "()J", "(J)V", "Lrx/subjects/Subject;", "emptyTextSubject", "Lrx/subjects/Subject;", "Lcom/discord/widgets/chat/input/MessageDraftsRepo;", "messageDraftsRepo", "Lcom/discord/widgets/chat/input/MessageDraftsRepo;", "<init>", "(Lcom/lytefast/flexinput/widget/FlexEditText;Lcom/discord/widgets/chat/input/MessageDraftsRepo;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputEditText {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long channelId;
    private final FlexEditText editText;
    private final Subject<Boolean, Boolean> emptyTextSubject;
    private long lastTypingEmissionMillis;
    private final MessageDraftsRepo messageDraftsRepo;
    private Function0<Unit> onSendListener;

    /* compiled from: WidgetChatInputEditText.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputEditText$Companion;", "", "Landroid/widget/TextView;", "textView", "", "toStringSafe", "(Landroid/widget/TextView;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final String toStringSafe(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            try {
                return textView.getText().toString();
            } catch (Exception unused) {
                return "";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatInputEditText.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputEditText$setHardwareKeyboardSendBehavior$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnKeyListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            Function0<Unit> onSendListener;
            Intrinsics3.checkNotNullParameter(keyEvent, "event");
            boolean z2 = (keyEvent.getFlags() & 2) == 2;
            if ((i == 66) && !z2) {
                boolean zHasModifiers = keyEvent.hasModifiers(1);
                boolean isShiftEnterToSendEnabled = StoreStream.INSTANCE.getUserSettings().getIsShiftEnterToSendEnabled();
                if ((isShiftEnterToSendEnabled && zHasModifiers) || (!isShiftEnterToSendEnabled && !zHasModifiers)) {
                    if (WidgetChatInputEditText.this.getOnSendListener() != null && keyEvent.getAction() == 1 && (onSendListener = WidgetChatInputEditText.this.getOnSendListener()) != null) {
                        onSendListener.invoke();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: WidgetChatInputEditText.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/discord/widgets/chat/input/WidgetChatInputEditText$setOnTextChangedListener$1", "Lcom/discord/utilities/view/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", "empty", "Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputEditText$setOnTextChangedListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends TextWatcher {
        private boolean empty;

        public AnonymousClass1() {
            super(null, null, null, 7, null);
            this.empty = true;
        }

        @Override // com.discord.utilities.view.text.TextWatcher, android.text.TextWatcher
        public void afterTextChanged(Editable s2) {
            Intrinsics3.checkNotNullParameter(s2, "s");
            super.afterTextChanged(s2);
            WidgetChatInputEditText.this.saveText();
            boolean zIsEmpty = TextUtils.isEmpty(s2);
            if (this.empty != zIsEmpty) {
                this.empty = zIsEmpty;
                WidgetChatInputEditText.access$getEmptyTextSubject$p(WidgetChatInputEditText.this).onNext(Boolean.valueOf(zIsEmpty));
            }
            boolean zStartsWith$default = Strings4.startsWith$default((CharSequence) s2.toString(), MentionUtils.SLASH_CHAR, false, 2, (Object) null);
            if (WidgetChatInputEditText.access$getLastTypingEmissionMillis$p(WidgetChatInputEditText.this) - ClockFactory.get().currentTimeMillis() >= -10000 || zIsEmpty || zStartsWith$default) {
                return;
            }
            WidgetChatInputEditText.access$setLastTypingEmissionMillis$p(WidgetChatInputEditText.this, ClockFactory.get().currentTimeMillis());
            StoreStream.INSTANCE.getUsersTyping().setUserTyping(WidgetChatInputEditText.this.getChannelId());
        }
    }

    /* compiled from: WidgetChatInputEditText.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/widget/TextView;", "<anonymous parameter 0>", "", "actionId", "Landroid/view/KeyEvent;", "<anonymous parameter 2>", "", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputEditText$setSoftwareKeyboardSendBehavior$1, reason: invalid class name */
    public static final class AnonymousClass1 implements TextView.OnEditorActionListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            int i2 = i & 255;
            if (WidgetChatInputEditText.this.getOnSendListener() == null || i2 != 6) {
                return false;
            }
            Function0<Unit> onSendListener = WidgetChatInputEditText.this.getOnSendListener();
            if (onSendListener == null) {
                return true;
            }
            onSendListener.invoke();
            return true;
        }
    }

    public WidgetChatInputEditText(FlexEditText flexEditText, MessageDraftsRepo messageDraftsRepo) {
        Intrinsics3.checkNotNullParameter(flexEditText, "editText");
        Intrinsics3.checkNotNullParameter(messageDraftsRepo, "messageDraftsRepo");
        this.editText = flexEditText;
        this.messageDraftsRepo = messageDraftsRepo;
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0(Boolean.TRUE);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(true)");
        this.emptyTextSubject = behaviorSubjectL0;
        setOnTextChangedListener();
        setSoftwareKeyboardSendBehavior();
        setHardwareKeyboardSendBehavior();
    }

    public static final /* synthetic */ Subject access$getEmptyTextSubject$p(WidgetChatInputEditText widgetChatInputEditText) {
        return widgetChatInputEditText.emptyTextSubject;
    }

    public static final /* synthetic */ long access$getLastTypingEmissionMillis$p(WidgetChatInputEditText widgetChatInputEditText) {
        return widgetChatInputEditText.lastTypingEmissionMillis;
    }

    public static final /* synthetic */ void access$setLastTypingEmissionMillis$p(WidgetChatInputEditText widgetChatInputEditText, long j) {
        widgetChatInputEditText.lastTypingEmissionMillis = j;
    }

    private final void setHardwareKeyboardSendBehavior() {
        this.editText.setOnKeyListener(new AnonymousClass1());
    }

    private final void setOnTextChangedListener() {
        this.editText.addTextChangedListener(new AnonymousClass1());
    }

    private final void setSoftwareKeyboardSendBehavior() {
        this.editText.setOnEditorActionListener(new AnonymousClass1());
    }

    public final void clearLastTypingEmission() {
        this.lastTypingEmissionMillis = 0L;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Function0<Unit> getOnSendListener() {
        return this.onSendListener;
    }

    public final String getText() {
        return INSTANCE.toStringSafe(this.editText);
    }

    public final void saveText() {
        this.messageDraftsRepo.setTextChannelInput(this.channelId, this.editText.getText());
    }

    public final void setChannelId(long j) {
        this.channelId = j;
    }

    public final void setOnSendListener(Function0<Unit> function0) {
        this.onSendListener = function0;
    }

    public final void setChannelId(long channelId, boolean saveExistingText) {
        if (saveExistingText) {
            saveText();
        }
        this.channelId = channelId;
    }

    public /* synthetic */ WidgetChatInputEditText(FlexEditText flexEditText, MessageDraftsRepo messageDraftsRepo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(flexEditText, (i & 2) != 0 ? MessageDraftsRepo.Provider.INSTANCE.get() : messageDraftsRepo);
    }
}
