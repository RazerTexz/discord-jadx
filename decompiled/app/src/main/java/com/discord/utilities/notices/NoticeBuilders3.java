package com.discord.utilities.notices;

import android.content.Context;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: NoticeBuilders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/content/Context;", "p1", "Lcom/discord/stores/StoreNotices$Dialog;", "p2", "Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", "invoke", "(Landroid/content/Context;Lcom/discord/stores/StoreNotices$Dialog;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.notices.NoticeBuilders$noticeDataBuilders$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class NoticeBuilders3 extends FunctionReferenceImpl implements Function2<Context, StoreNotices.Dialog, NoticeBuilders.DialogData> {
    public NoticeBuilders3(NoticeBuilders noticeBuilders) {
        super(2, noticeBuilders, NoticeBuilders.class, "deleteConnectionModalBuilder", "deleteConnectionModalBuilder(Landroid/content/Context;Lcom/discord/stores/StoreNotices$Dialog;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ NoticeBuilders.DialogData invoke(Context context, StoreNotices.Dialog dialog) {
        return invoke2(context, dialog);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NoticeBuilders.DialogData invoke2(Context context, StoreNotices.Dialog dialog) {
        Intrinsics3.checkNotNullParameter(context, "p1");
        Intrinsics3.checkNotNullParameter(dialog, "p2");
        return NoticeBuilders.access$deleteConnectionModalBuilder((NoticeBuilders) this.receiver, context, dialog);
    }
}
