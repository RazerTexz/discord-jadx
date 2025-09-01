package com.discord.api.user;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Phone.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/api/user/Phone;", "", "<init>", "()V", "NoPhoneNumber", "PhoneNumber", "Lcom/discord/api/user/Phone$PhoneNumber;", "Lcom/discord/api/user/Phone$NoPhoneNumber;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class Phone {

    /* compiled from: Phone.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/user/Phone$NoPhoneNumber;", "Lcom/discord/api/user/Phone;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class NoPhoneNumber extends Phone {
        public static final NoPhoneNumber INSTANCE = new NoPhoneNumber();

        public NoPhoneNumber() {
            super(null);
        }
    }

    /* compiled from: Phone.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/discord/api/user/Phone$PhoneNumber;", "Lcom/discord/api/user/Phone;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "number", "Ljava/lang/String;", "a", "<init>", "(Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PhoneNumber extends Phone {
        private final String number;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PhoneNumber(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "number");
            this.number = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getNumber() {
            return this.number;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PhoneNumber) && Intrinsics3.areEqual(this.number, ((PhoneNumber) other).number);
            }
            return true;
        }

        public int hashCode() {
            String str = this.number;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("PhoneNumber(number="), this.number, ")");
        }
    }

    public Phone() {
    }

    public Phone(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
