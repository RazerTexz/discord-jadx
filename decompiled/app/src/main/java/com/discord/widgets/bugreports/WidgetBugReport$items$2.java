package com.discord.widgets.bugreports;

import b.a.k.FormatUtils;
import b.a.y.SelectorBottomSheet2;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.t.Iterables2;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetBugReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lb/a/y/c0;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetBugReport$items$2 extends Lambda implements Function0<List<? extends SelectorBottomSheet2>> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$items$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends SelectorBottomSheet2> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends SelectorBottomSheet2> invoke2() {
        List<Priority> priorityLevels = WidgetBugReport.INSTANCE.getPriorityLevels();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(priorityLevels, 10));
        for (Priority priority : priorityLevels) {
            arrayList.add(new SelectorBottomSheet2(this.this$0.getString(priority.getTitle()), FormatUtils.k(this.this$0, priority.getDescription(), new Object[0], null, 4), null, ModelEmojiCustom.getImageUri(priority.getEmojiId(), true, 64), null, null, null, 116));
        }
        return arrayList;
    }
}
