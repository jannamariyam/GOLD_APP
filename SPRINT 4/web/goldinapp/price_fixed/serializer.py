from rest_framework import serializers
from .models import PriceFixed
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=PriceFixed
        fields='__all__'
