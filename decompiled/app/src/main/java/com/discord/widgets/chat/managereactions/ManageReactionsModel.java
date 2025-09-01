package com.discord.widgets.chat.managereactions;

import b.d.b.a.outline;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ManageReactionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J0\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", "", "", "Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter$ReactionEmojiItem;", "component1", "()Ljava/util/List;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "component2", "reactionItems", "userItems", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getReactionItems", "getUserItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ManageReactionsModel {
    private final List<ManageReactionsEmojisAdapter.ReactionEmojiItem> reactionItems;
    private final List<MGRecyclerDataPayload> userItems;

    /* JADX WARN: Multi-variable type inference failed */
    public ManageReactionsModel(List<ManageReactionsEmojisAdapter.ReactionEmojiItem> list, List<? extends MGRecyclerDataPayload> list2) {
        Intrinsics3.checkNotNullParameter(list, "reactionItems");
        Intrinsics3.checkNotNullParameter(list2, "userItems");
        this.reactionItems = list;
        this.userItems = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ManageReactionsModel copy$default(ManageReactionsModel manageReactionsModel, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = manageReactionsModel.reactionItems;
        }
        if ((i & 2) != 0) {
            list2 = manageReactionsModel.userItems;
        }
        return manageReactionsModel.copy(list, list2);
    }

    public final List<ManageReactionsEmojisAdapter.ReactionEmojiItem> component1() {
        return this.reactionItems;
    }

    public final List<MGRecyclerDataPayload> component2() {
        return this.userItems;
    }

    public final ManageReactionsModel copy(List<ManageReactionsEmojisAdapter.ReactionEmojiItem> reactionItems, List<? extends MGRecyclerDataPayload> userItems) {
        Intrinsics3.checkNotNullParameter(reactionItems, "reactionItems");
        Intrinsics3.checkNotNullParameter(userItems, "userItems");
        return new ManageReactionsModel(reactionItems, userItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageReactionsModel)) {
            return false;
        }
        ManageReactionsModel manageReactionsModel = (ManageReactionsModel) other;
        return Intrinsics3.areEqual(this.reactionItems, manageReactionsModel.reactionItems) && Intrinsics3.areEqual(this.userItems, manageReactionsModel.userItems);
    }

    public final List<ManageReactionsEmojisAdapter.ReactionEmojiItem> getReactionItems() {
        return this.reactionItems;
    }

    public final List<MGRecyclerDataPayload> getUserItems() {
        return this.userItems;
    }

    public int hashCode() {
        List<ManageReactionsEmojisAdapter.ReactionEmojiItem> list = this.reactionItems;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<MGRecyclerDataPayload> list2 = this.userItems;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ManageReactionsModel(reactionItems=");
        sbU.append(this.reactionItems);
        sbU.append(", userItems=");
        return outline.L(sbU, this.userItems, ")");
    }
}
