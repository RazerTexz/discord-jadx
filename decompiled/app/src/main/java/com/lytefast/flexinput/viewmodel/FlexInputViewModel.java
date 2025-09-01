package com.lytefast.flexinput.viewmodel;

import android.view.View;
import b.b.a.h.FlexInputEvent;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: FlexInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\nJ\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0016H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0018H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\u0018H&¢\u0006\u0004\b&\u0010'J#\u0010+\u001a\u00020\b2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010)0(H&¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\bH&¢\u0006\u0004\b-\u0010\nJ\u000f\u0010.\u001a\u00020\u0018H&¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u00020\bH&¢\u0006\u0004\b/\u0010\nJ\u001d\u00102\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\b00H&¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0018H&¢\u0006\u0004\b4\u0010 J\u001d\u00106\u001a\u00020\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010)H&¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0018H&¢\u0006\u0004\b8\u0010 ¨\u00069"}, d2 = {"Lcom/lytefast/flexinput/viewmodel/FlexInputViewModel;", "", "Lrx/Observable;", "Lcom/lytefast/flexinput/viewmodel/FlexInputState;", "observeState", "()Lrx/Observable;", "Lb/b/a/h/a;", "observeEvents", "", "onGalleryButtonClicked", "()V", "onGiftButtonClicked", "", "index", "onContentDialogPageChanged", "(I)V", "onExpandButtonClicked", "onExpressionTrayButtonClicked", "Lcom/lytefast/flexinput/FlexInputListener;", "inputListener", "onSendButtonClicked", "(Lcom/lytefast/flexinput/FlexInputListener;)V", "", "inputText", "", "focused", "onInputTextChanged", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "appendText", "onInputTextAppended", "(Ljava/lang/String;)V", "onInputTextClicked", "()Z", "Landroid/view/View;", "button", "onToolTipButtonLongPressed", "(Landroid/view/View;)Z", "showKeyboard", "onContentDialogDismissed", "(Z)V", "", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "onAttachmentsUpdated", "(Ljava/util/List;)V", "onFlexInputFragmentPause", "hideExpressionTray", "onCreateThreadSelected", "Lkotlin/Function0;", "onSuccess", "requestMediaPermissions", "(Lkotlin/jvm/functions/Function0;)V", "hasMediaPermissions", "attachment", "onSingleAttachmentSelected", "(Lcom/lytefast/flexinput/model/Attachment;)V", "isSingleSelectMode", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface FlexInputViewModel {
    boolean hasMediaPermissions();

    boolean hideExpressionTray();

    boolean isSingleSelectMode();

    Observable<FlexInputEvent> observeEvents();

    Observable<FlexInputState> observeState();

    void onAttachmentsUpdated(List<? extends Attachment<? extends Object>> attachments);

    void onContentDialogDismissed(boolean showKeyboard);

    void onContentDialogPageChanged(int index);

    void onCreateThreadSelected();

    void onExpandButtonClicked();

    void onExpressionTrayButtonClicked();

    void onFlexInputFragmentPause();

    void onGalleryButtonClicked();

    void onGiftButtonClicked();

    void onInputTextAppended(String appendText);

    void onInputTextChanged(String inputText, Boolean focused);

    boolean onInputTextClicked();

    void onSendButtonClicked(FlexInputListener inputListener);

    void onSingleAttachmentSelected(Attachment<? extends Object> attachment);

    boolean onToolTipButtonLongPressed(View button);

    void requestMediaPermissions(Function0<Unit> onSuccess);
}
