package com.discord.widgets.guilds.contextmenu;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: FolderContextMenuViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0002*\u0004\u0018\u00010\b0\b2\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\"\u0010\u0007\u001a\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0002*\u000e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lcom/discord/models/domain/ModelGuildFolder;", "kotlin.jvm.PlatformType", "guildFolders", "", "", "Lcom/discord/primitives/GuildId;", "unreadGuildIds", "Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/Set;)Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FolderContextMenuViewModel2<T1, T2, R> implements Func2<List<? extends ModelGuildFolder>, Set<? extends Long>, FolderContextMenuViewModel.StoreState> {
    public final /* synthetic */ long $folderId;

    public FolderContextMenuViewModel2(long j) {
        this.$folderId = j;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ FolderContextMenuViewModel.StoreState call(List<? extends ModelGuildFolder> list, Set<? extends Long> set) {
        return call2((List<ModelGuildFolder>) list, (Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final FolderContextMenuViewModel.StoreState call2(List<ModelGuildFolder> list, Set<Long> set) {
        Object next;
        Intrinsics3.checkNotNullExpressionValue(list, "guildFolders");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Long id2 = ((ModelGuildFolder) next).getId();
            if (id2 != null && id2.longValue() == this.$folderId) {
                break;
            }
        }
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) next;
        if (modelGuildFolder == null) {
            return FolderContextMenuViewModel.StoreState.Invalid.INSTANCE;
        }
        Intrinsics3.checkNotNullExpressionValue(set, "unreadGuildIds");
        return new FolderContextMenuViewModel.StoreState.Valid(modelGuildFolder, set);
    }
}
