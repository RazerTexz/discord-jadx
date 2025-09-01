package com.lytefast.flexinput;

import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FlexInputListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u00002\u00020\u0001J?\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/lytefast/flexinput/FlexInputListener;", "", "", "data", "", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "Lkotlin/Function1;", "", "", "onSendResult", "onSend", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface FlexInputListener {
    void onSend(String data, List<? extends Attachment<?>> attachments, Function1<? super Boolean, Unit> onSendResult);
}
