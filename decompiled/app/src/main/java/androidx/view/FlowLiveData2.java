package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import s.a.c2.Channel4;

/* compiled from: FlowLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1, reason: use source file name */
/* loaded from: classes.dex */
public final class FlowLiveData2<T> implements Observer<T> {
    public final /* synthetic */ Channel4 $channel;

    public FlowLiveData2(Channel4 channel4) {
        this.$channel = channel4;
    }

    @Override // androidx.view.Observer
    public final void onChanged(T t) {
        this.$channel.offer(t);
    }
}
