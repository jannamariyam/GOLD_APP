from rest_framework import serializers
from .models import Penaltyentry
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=Penaltyentry
        fields='__all__'