package com.discord.utilities.search.query.node;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.search.query.node.answer.AnswerNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.Strings4;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: QueryNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\b&\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/discord/utilities/search/query/node/QueryNode;", "Lcom/discord/simpleast/core/node/Node;", "Landroid/content/Context;", "", "getText", "()Ljava/lang/CharSequence;", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "<init>", "()V", "Preprocessor", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class QueryNode extends Node<Context> {

    /* renamed from: Preprocessor, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: QueryNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/search/query/node/QueryNode$Preprocessor;", "", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "", "consolidateContentNodes", "(Ljava/util/List;)V", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "preprocess", "(Ljava/util/List;Lcom/discord/utilities/search/validation/SearchData;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.query.node.QueryNode$Preprocessor, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final void consolidateContentNodes(List<QueryNode> list) {
            int i = 1;
            while (i < list.size()) {
                int i2 = i - 1;
                QueryNode queryNode = list.get(i2);
                QueryNode queryNode2 = list.get(i);
                if ((queryNode instanceof ContentNode) && (queryNode2 instanceof ContentNode)) {
                    list.set(i2, new ContentNode((ContentNode) queryNode, (ContentNode) queryNode2));
                    list.remove(i);
                    i--;
                }
                i++;
            }
            if (!list.isEmpty()) {
                int size = list.size() - 1;
                QueryNode queryNode3 = list.get(size);
                if (queryNode3 instanceof ContentNode) {
                    if (Strings4.trim(((ContentNode) queryNode3).getContent()).length() == 0) {
                        list.remove(size);
                    }
                }
            }
        }

        public final void preprocess(List<QueryNode> list, SearchData searchData) {
            Intrinsics3.checkNotNullParameter(list, "$this$preprocess");
            Intrinsics3.checkNotNullParameter(searchData, "searchData");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (QueryNode contentNode : list) {
                if ((contentNode instanceof AnswerNode) && !((AnswerNode) contentNode).isValid(searchData)) {
                    contentNode = new ContentNode(contentNode.getText());
                }
                arrayList.add(contentNode);
            }
            QueryNode.INSTANCE.consolidateContentNodes(list);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public QueryNode() {
        super(null, 1, null);
    }

    public abstract CharSequence getText();
}
