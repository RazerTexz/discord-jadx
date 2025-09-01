package com.discord.widgets.forums;

import b.d.b.a.outline;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ForumBrowserItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0003\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/forums/ForumBrowserItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "<init>", "(Ljava/lang/String;I)V", "Companion", "HeaderItem", "LoadingItem", "PostItem", "Lcom/discord/widgets/forums/ForumBrowserItem$HeaderItem;", "Lcom/discord/widgets/forums/ForumBrowserItem$PostItem;", "Lcom/discord/widgets/forums/ForumBrowserItem$LoadingItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class ForumBrowserItem implements MGRecyclerDataPayload {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_LOADING = 2;
    public static final int TYPE_POST = 1;
    private final String key;
    private final int type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy postItemComparatorByMostRecent$delegate = LazyJVM.lazy(ForumBrowserItem2.INSTANCE);

    /* compiled from: ForumBrowserItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/forums/ForumBrowserItem$Companion;", "", "Ljava/util/Comparator;", "Lcom/discord/widgets/forums/ForumBrowserItem$PostItem;", "postItemComparatorByMostRecent$delegate", "Lkotlin/Lazy;", "getPostItemComparatorByMostRecent", "()Ljava/util/Comparator;", "postItemComparatorByMostRecent", "", "TYPE_HEADER", "I", "TYPE_LOADING", "TYPE_POST", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Comparator<PostItem> getPostItemComparatorByMostRecent() {
            Lazy lazyAccess$getPostItemComparatorByMostRecent$cp = ForumBrowserItem.access$getPostItemComparatorByMostRecent$cp();
            Companion companion = ForumBrowserItem.INSTANCE;
            return (Comparator) lazyAccess$getPostItemComparatorByMostRecent$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ForumBrowserItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/forums/ForumBrowserItem$HeaderItem;", "Lcom/discord/widgets/forums/ForumBrowserItem;", "", "component1", "()I", "stringResId", "copy", "(I)Lcom/discord/widgets/forums/ForumBrowserItem$HeaderItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStringResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class HeaderItem extends ForumBrowserItem {
        private final int stringResId;

        public HeaderItem(int i) {
            super(String.valueOf(i), 0, null);
            this.stringResId = i;
        }

        public static /* synthetic */ HeaderItem copy$default(HeaderItem headerItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = headerItem.stringResId;
            }
            return headerItem.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStringResId() {
            return this.stringResId;
        }

        public final HeaderItem copy(int stringResId) {
            return new HeaderItem(stringResId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof HeaderItem) && this.stringResId == ((HeaderItem) other).stringResId;
            }
            return true;
        }

        public final int getStringResId() {
            return this.stringResId;
        }

        public int hashCode() {
            return this.stringResId;
        }

        public String toString() {
            return outline.B(outline.U("HeaderItem(stringResId="), this.stringResId, ")");
        }
    }

    /* compiled from: ForumBrowserItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/forums/ForumBrowserItem$LoadingItem;", "Lcom/discord/widgets/forums/ForumBrowserItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingItem extends ForumBrowserItem {
        public static final LoadingItem INSTANCE = new LoadingItem();

        private LoadingItem() {
            super("loading-indicator", 2, null);
        }
    }

    /* compiled from: ForumBrowserItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/forums/ForumBrowserItem$PostItem;", "Lcom/discord/widgets/forums/ForumBrowserItem;", "Lcom/discord/widgets/forums/PostData;", "component1", "()Lcom/discord/widgets/forums/PostData;", "post", "copy", "(Lcom/discord/widgets/forums/PostData;)Lcom/discord/widgets/forums/ForumBrowserItem$PostItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/forums/PostData;", "getPost", "<init>", "(Lcom/discord/widgets/forums/PostData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PostItem extends ForumBrowserItem {
        private final PostData post;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostItem(PostData postData) {
            super(String.valueOf(postData.getChannel().getId()), 1, null);
            Intrinsics3.checkNotNullParameter(postData, "post");
            this.post = postData;
        }

        public static /* synthetic */ PostItem copy$default(PostItem postItem, PostData postData, int i, Object obj) {
            if ((i & 1) != 0) {
                postData = postItem.post;
            }
            return postItem.copy(postData);
        }

        /* renamed from: component1, reason: from getter */
        public final PostData getPost() {
            return this.post;
        }

        public final PostItem copy(PostData post) {
            Intrinsics3.checkNotNullParameter(post, "post");
            return new PostItem(post);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PostItem) && Intrinsics3.areEqual(this.post, ((PostItem) other).post);
            }
            return true;
        }

        public final PostData getPost() {
            return this.post;
        }

        public int hashCode() {
            PostData postData = this.post;
            if (postData != null) {
                return postData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PostItem(post=");
            sbU.append(this.post);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private ForumBrowserItem(String str, int i) {
        this.key = str;
        this.type = i;
    }

    public static final /* synthetic */ Lazy access$getPostItemComparatorByMostRecent$cp() {
        return postItemComparatorByMostRecent$delegate;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ ForumBrowserItem(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
