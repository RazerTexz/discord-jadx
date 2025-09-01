package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ActivityResultCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "O", "androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "invoke", "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityResultCaller6 extends Lambda implements Function0<AnonymousClass1> {
    public final /* synthetic */ ActivityResultCaller5 this$0;

    /* JADX INFO: Add missing generic type declarations: [O] */
    /* compiled from: ActivityResultCaller.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/content/Context;", "context", "void", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Lkotlin/Unit;)Landroid/content/Intent;", "", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Ljava/lang/Object;", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
    /* renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1, reason: invalid class name */
    public static final class AnonymousClass1<O> extends ActivityResultContract<Unit, O> {
        public AnonymousClass1() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context context, Unit unit) {
            return createIntent2(context, unit);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public O parseResult(int resultCode, Intent intent) {
            return (O) ActivityResultCaller6.this.this$0.getCallerContract().parseResult(resultCode, intent);
        }

        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context context, Unit unit) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentCreateIntent = ActivityResultCaller6.this.this$0.getCallerContract().createIntent(context, ActivityResultCaller6.this.this$0.getInput());
            Intrinsics3.checkNotNullExpressionValue(intentCreateIntent, "callerContract.createIntent(context, input)");
            return intentCreateIntent;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityResultCaller6(ActivityResultCaller5 activityResultCaller5) {
        super(0);
        this.this$0 = activityResultCaller5;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnonymousClass1 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        return new AnonymousClass1();
    }
}
