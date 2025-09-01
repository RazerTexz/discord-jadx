package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetDirectoriesViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "", "Lcom/discord/widgets/directories/DirectoryEntryData;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$ViewState$directoryEntryData$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel4 extends Lambda implements Function0<Map<Integer, ? extends List<? extends DirectoryEntryData>>> {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel4(WidgetDirectoriesViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Integer, ? extends List<? extends DirectoryEntryData>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Integer, ? extends List<? extends DirectoryEntryData>> invoke2() {
        List<DirectoryEntryGuild> listInvoke = this.this$0.getDirectories().invoke();
        if (listInvoke == null) {
            listInvoke = Collections2.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (DirectoryEntryGuild directoryEntryGuild : listInvoke) {
            Integer numValueOf = Integer.valueOf(directoryEntryGuild.getPrimaryCategoryId());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return linkedHashMap;
    }
}
