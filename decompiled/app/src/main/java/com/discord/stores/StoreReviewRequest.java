package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.StoreNotices;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: StoreReviewRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/StoreReviewRequest;", "Lcom/discord/stores/Store;", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "onReviewRequestShown", "()V", "onUserAcceptedRequest", "onUserDismissedRequest", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "", "requestedReviewRevision", "I", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "", "hasUserAcceptedReviewRequest", "Z", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreStream;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreReviewRequest extends Store {
    private static final int MINIMUM_GUILD_MEMBER_COUNT = 5;
    private static final long MINIMUM_INSTALL_AGE = 864000000;
    private static final int REVIEW_REQUEST_REVISION = 693;
    private final Clock clock;
    private boolean hasUserAcceptedReviewRequest;
    private int requestedReviewRevision;
    private final StoreStream stream;

    public StoreReviewRequest(Clock clock, StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.requestedReviewRevision = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleConnectionOpen(ModelPayload payload) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        boolean z3 = true;
        if (guilds == null) {
            z3 = false;
        } else if (guilds.isEmpty()) {
            z2 = false;
            if (!z2) {
            }
        } else {
            Iterator<T> it = guilds.iterator();
            while (it.hasNext()) {
                if (((Guild) it.next()).getMemberCount() >= 5) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        Boolean verified = payload.getMe().getVerified();
        boolean zBooleanValue = verified != null ? verified.booleanValue() : false;
        if (!z3 || !zBooleanValue || this.hasUserAcceptedReviewRequest || this.requestedReviewRevision >= REVIEW_REQUEST_REVISION) {
            return;
        }
        if (this.clock.currentTimeMillis() <= this.stream.getNotices().getFirstUseTimestamp() + MINIMUM_INSTALL_AGE) {
            return;
        }
        this.stream.getNotices().requestToShow(StoreNotices.Dialog.Type.buildPassiveNotice$default(StoreNotices.Dialog.Type.REQUEST_RATING_MODAL, 0, 31536000000L, 0L, true, 5, null));
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.requestedReviewRevision = getPrefsSessionDurable().getInt("CACHE_KEY_VIEWED_REVIEW_REQUEST_REVISION", this.requestedReviewRevision);
        this.hasUserAcceptedReviewRequest = getPrefsSessionDurable().getBoolean("CACHE_KEY_HAS_ACCEPTED_REVIEW_REQUEST", this.hasUserAcceptedReviewRequest);
    }

    public final void onReviewRequestShown() {
        this.requestedReviewRevision = REVIEW_REQUEST_REVISION;
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putInt("CACHE_KEY_VIEWED_REVIEW_REQUEST_REVISION", REVIEW_REQUEST_REVISION);
        editorEdit.apply();
        this.stream.getNotices().markSeen(StoreNotices.Dialog.Type.REQUEST_RATING_MODAL);
        AnalyticsTracker.INSTANCE.reviewRequestTriggered();
    }

    public final void onUserAcceptedRequest() {
        this.hasUserAcceptedReviewRequest = true;
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_HAS_ACCEPTED_REVIEW_REQUEST", true);
        editorEdit.apply();
        AnalyticsTracker.INSTANCE.reviewRequestAccepted();
    }

    public final void onUserDismissedRequest() {
        AnalyticsTracker.INSTANCE.reviewRequestDismissed();
    }
}
