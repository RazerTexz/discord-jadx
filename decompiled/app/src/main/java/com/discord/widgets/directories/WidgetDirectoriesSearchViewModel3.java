package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.WidgetDirectoriesSearchViewModel;
import d0.t.Iterables2;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetDirectoriesSearchViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/widgets/directories/DirectoryEntryData;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$ViewState$directoryEntryData$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel3 extends Lambda implements Function0<List<? extends DirectoryEntryData>> {
    public final /* synthetic */ WidgetDirectoriesSearchViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel3(WidgetDirectoriesSearchViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends DirectoryEntryData> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends DirectoryEntryData> invoke2() {
        List<DirectoryEntryGuild> directories = this.this$0.getDirectories();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(directories, 10));
        for (DirectoryEntryGuild directoryEntryGuild : directories) {
            arrayList.add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return arrayList;
    }
}
