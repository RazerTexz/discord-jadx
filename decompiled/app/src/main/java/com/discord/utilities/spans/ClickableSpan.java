package com.discord.utilities.spans;

import android.text.TextPaint;
import android.view.View;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ClickableSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/spans/ClickableSpan;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "view", "", "onClick", "(Landroid/view/View;)V", "onLongPress", "(Landroid/view/View;)Lkotlin/Unit;", "Landroid/text/TextPaint;", "drawState", "updateDrawState", "(Landroid/text/TextPaint;)V", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "onClickListener", "", "underline", "Z", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "Ljava/lang/Integer;", "<init>", "(Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ClickableSpan extends android.text.style.ClickableSpan {
    private final Integer color;
    private final Function1<View, Unit> onClickListener;
    private final Function1<View, Unit> onLongPress;
    private final boolean underline;

    public /* synthetic */ ClickableSpan(Integer num, boolean z2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, z2, (i & 4) != 0 ? null : function1, function12);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        this.onClickListener.invoke(view);
    }

    public final Unit onLongPress(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Function1<View, Unit> function1 = this.onLongPress;
        if (function1 != null) {
            return function1.invoke(view);
        }
        return null;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint drawState) {
        Intrinsics3.checkNotNullParameter(drawState, "drawState");
        drawState.setUnderlineText(this.underline);
        Integer num = this.color;
        if (num != null) {
            drawState.setColor(num.intValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClickableSpan(Integer num, boolean z2, Function1<? super View, Unit> function1, Function1<? super View, Unit> function12) {
        Intrinsics3.checkNotNullParameter(function12, "onClickListener");
        this.color = num;
        this.underline = z2;
        this.onLongPress = function1;
        this.onClickListener = function12;
    }
}
